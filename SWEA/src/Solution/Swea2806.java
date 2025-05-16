package Solution;

import java.io.*;
import java.util.*;

public class Swea2806 {
	static int N, count;
	static int[] cols;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tcNum = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcNum; tc++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			cols = new int[N];
			for(int i = 0; i < N; i++) {
				cols[0] = i;
				find(i,0);
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
		static void find(int col, int row) {
			if(row == N-1) {
				count++;
			}else {
				int nextRow = row+1;
				for(int i = 0; i < N; i++) {
					if(isCorrect(i, nextRow)) {
						cols[nextRow] = i;
						find(i,nextRow);
					}
				}
			}
		}
		static boolean isCorrect(int col, int row) {
			for(int i =0; i < row; i++) {
				if(cols[i] == col) return false;
				if(Math.abs(cols[i]-i) == Math.abs(col-row))return false;
			}
			return true;
		}
}
