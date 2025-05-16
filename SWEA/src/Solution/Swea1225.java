package Solution;

import java.util.*;
import java.io.*;

public class Swea1225 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tcNum = 10;
		while(tcNum-- > 0) {
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			outer : while(true) {
				for(int i = 1; i <= 5; i++) {
					int cur = q.poll() - i;
					if(cur < 0) cur = 0;
					q.add(cur);
					if(cur == 0) break outer;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i : q) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
