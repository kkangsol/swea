package Solution;

import java.io.*;
import java.util.*;

public class Swea1226 {
	static int startX, startY, endX, endY, answer;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static char[][] map = new char[16][16];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc = 1; tc <= 10; tc++) {
			int testCase = Integer.parseInt(br.readLine());
			for(int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
			}
		
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					if(map[i][j] == '2') {
						startY = i;
						startX = j;
					}
					if(map[i][j] == '3') {
						endY = i;
						endX = j;
					}
				}
			}
			answer = 0;
			BFS(startY, startX);
			bw.write("#" + testCase + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void BFS(int y, int x) {
		Queue<int[]> q= new LinkedList<>();
		map[y][x] = '1';
		q.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			for(int i = 0; i < 4; i++) {
				int nextY = curY + dirY[i];
				int nextX = curX + dirX[i];
				if(nextX >= 0 && nextY >= 0 && nextX < 16 && nextY < 16) {
					if(nextX == endX && nextY == endY) {
						answer = 1;
						return;
					}
					if(map[nextY][nextX] == '0') {
						map[nextY][nextX] = '1';
						q.add(new int[] {nextY, nextX});
					}
				}
			}
		}
	}
}






