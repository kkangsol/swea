package Solution;

import java.io.*;
import java.util.*;


public class Swea1859 {
	static int start, end, sum, buy, count;
	static int[] days;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			days = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			start = sum = 0;
			end = N-1;
			while(start < N) {
				buy = count = 0;
				findMax(start, end);
				for(int i = start; i < end; i++) {
					buy += days[i];
					count++;
				}
				sum += count*days[end]-buy;
				start = end+1;
				end = N-1;
			}
			bw.write("#" + tc + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	static void findMax(int start, int ended) {
		int max = 0;
		for(int i = start; i <= ended;i++) {
			if(max < days[i]) {
				max = days[i];
				end = i;
			}
		}
	}
}
