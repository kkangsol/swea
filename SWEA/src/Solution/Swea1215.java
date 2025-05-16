package Solution;

import java.io.*;
import java.util.*;

public class Swea1215 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tcNum = 10;
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for(int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			int answer = 0;
			for(int i = 0; i < 8; i++) {
				for(int count = 0; count <= 8-n; count++) {
					StringBuilder garo = new StringBuilder();
					StringBuilder sero = new StringBuilder();
					for(int j = count; j < count+n; j++) {
						garo.append(arr[i][j]);
						sero.append(arr[j][i]);
					}

					if(garo.toString().equals(garo.reverse().toString()))answer++;
					if(sero.toString().equals(sero.reverse().toString()))answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
