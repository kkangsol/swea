package Solution;

import java.util.*;
import java.io.*;

public class Swea1209 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int Tc = 10;
		while(Tc-- > 0) {
			int testCase = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			int garoM = 0;
			int seroM = 0;
			int downM = 0;
			int upM = 0;
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 100; i++) {
				int garo = 0;
				int sero = 0;
				for(int j = 0; j < 100; j++) {
					garo += map[i][j];
					sero += map[j][i];
				}
				garoM = Math.max(garoM, garo);
				seroM = Math.max(seroM, sero);
				downM += map[i][i];
				upM += map[i][99-i];
			}
			int maxValue = Math.max(Math.max(garoM, seroM), Math.max(downM, upM));
			sb.append("#").append(testCase).append(" ").append(maxValue).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
