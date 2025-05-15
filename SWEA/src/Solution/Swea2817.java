package Solution;

import java.io.*;
import java.util.*;

public class Swea2817 {
	static int N, K, count;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			count = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0, 0);
			bw.write("#" + tc + " " + count + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void DFS(int sum, int index) {
		if(sum == K) {
			count++;
		}else {
			for(int i = index; i < N; i++) {
				DFS(sum+arr[i], i+1);
			}
		}
	}
	
}
