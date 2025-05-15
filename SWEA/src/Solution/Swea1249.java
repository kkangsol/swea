package Solution;

import java.io.*;
import java.util.*;

public class Swea1249 {
	static int N;
	static int[][]map, sumMap;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static class Point implements Comparable<Point>{
		int y;
		int x;
		int cost;
		Point(int y, int x, int cost){
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
			//올림차순
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			sumMap = new int[N][N];
			char[] charArr = new char[N];
			for(int i = 0; i < N; i++) {
				charArr = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = charArr[j]-'0';
					sumMap[i][j] = Integer.MAX_VALUE;
				}
			}
			sumMap[0][0] = 0;
			BFS(0, 0, 0);
			bw.write("#" + tc + " " + sumMap[N-1][N-1] + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void BFS(int y, int x, int cost) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(y, x, cost));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int curY = cur.y;
			int curX = cur.x;
			int curCost = cur.cost;
			if(curCost > sumMap[curY][curX]) continue;
			for(int d = 0; d < 4; d++) {
				int nextY = curY + dirY[d];
				int nextX = curX + dirX[d];			
				if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < N ) {
					int nextCost = curCost + map[nextY][nextX];
					if(nextCost < sumMap[nextY][nextX]) {
						sumMap[nextY][nextX] = nextCost;
						q.add(new Point(nextY, nextX, nextCost));
					}
				}
			}
		}
	}
}
