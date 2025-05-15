package Solution;

import java.io.*;
import java.util.*;

public class Swea1805 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tcNum = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			char[][] charMap = new char[N][N];
			for(int i = 0; i < N; i++) {
				charMap[i] = br.readLine().toCharArray();
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = charMap[i][j] - '0';
				}
			}
			
			int start = N/2;
			int end = N/2;
			int sum = 0;
			
			while(start != 0) {
				for(int i = 0; i < N/2; i++) {
					for(int j = start; j <= end; j++) {
						sum+= map[i][j] + map[N-1-i][j];
					}
					start--;
					end++;
				}
			}
			
			for(int i : map[N/2]) {
				sum += i;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
