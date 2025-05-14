package Solution;

import java.io.*;
import java.util.*;


public class Swea1206 {
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int tc = 1; tc <=10; tc++ ) {
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(tc).append(" ");
				int N = Integer.parseInt(br.readLine());
				int[] buildings = new int[N];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					buildings[i] = Integer.parseInt(st.nextToken());
				}
				int count = 0;
				for(int i = 2; i < N-2; i++) {
					int highest = Math.max(Math.max(buildings[i-2],buildings[i-1]),Math.max(buildings[i+2],buildings[i+1]));
					if(buildings[i] > highest) count += (buildings[i]-highest);
				}
				sb.append(count).append("\n");
				bw.write(sb.toString());
			}
			bw.flush();
			bw.close();	
	}
}
