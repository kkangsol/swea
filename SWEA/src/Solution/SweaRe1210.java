package Solution;

import java.io.*;
import java.util.*;


public class SweaRe1210 {
	static int[][] map = new int[100][100];
	static boolean[][] visited;
	static int[] dirY = {1, 0, 0};
	static int[] dirX = {0, 1, -1};	// 아래 오른 왼
	static int answer, dir;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int testCase = Integer.parseInt(br.readLine());
			
			//사다리 map 만들기
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			dir = 0;
			for(int i = 0; i < 100; i++) {
				visited = new boolean[100][100];
				if(map[0][i] == 1) {
					if(go(0,i))answer = i;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static boolean go(int y, int x) {
		visited[y][x] = true;
		while(y < 99) {
			if(x+1 < 100 && map[y][x+1] == 1 && !visited[y][x+1]) dir = 1;
			else if(x-1 >= 0 && map[y][x-1] == 1 && !visited[y][x-1]) dir = 2;
			else dir = 0;
			y += dirY[dir];
			x += dirX[dir];
			visited[y][x] = true;
		}
		if (map[99][x] == 2) return true;
		else return false;
	}
	
}
