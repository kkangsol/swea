package Solution;

import java.io.*;
import java.util.*;

public class Swea1860 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 손님 수
			int M = Integer.parseInt(st.nextToken());	// 만드는 시간
			int K = Integer.parseInt(st.nextToken());	// 시간당 붕어빵 개수
			int[] guest = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				guest[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(guest);
			int maxTime = guest[N-1];
			int index = 0;
			String answer = (guest[0] != 0)?"Possible" : "Impossible";
			int[] made = new int[maxTime+1];
			outer : for(int i = 1; i <= maxTime; i++) {
				if(i%M == 0) made[i] = made[i-1]+K;
				else made[i] = made[i-1];
				if(i == guest[index]) {
					while(index < N && i == guest[index]) {
						if(made[i] <= 0) {
							answer = "Impossible";
							break outer;
						}else {
							index++;
							made[i]--;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
