package Solution;

import java.io.*;
import java.util.*;

public class Swea1208 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			while(N-- > 0) {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			int answer = arr[99]-arr[0];
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
