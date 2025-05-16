package Solution;

import java.io.*;
import java.util.*;

public class Swea1240 {
	static String[] encode = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"}; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tcNum = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcNum; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//가로
			int M = Integer.parseInt(st.nextToken());	//세로
			char[][] arr = new char[N][M];
			char[] codes = new char[56];
			int[] answer = new int[9];
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			outer : for(int i = 0; i < N; i++) {
				for(int j = M-1; j >= 0; j--) {
					if(arr[i][j] == '1') {
						int index = 55;
						for(int k = j; k > j-56; k--) {
							codes[index--] = arr[i][k];
						}
						break outer;
					}
				}
			}
			
			int start = 0;
			int answerIndex = 1;
			for(int j = 0; j < 8; j++) {
				String curCode = "";
				for(int i = start; i < start+7; i++) {
					curCode += codes[i];
				}
				for(int i = 0; i < 10; i++) {
					if(curCode.equals(encode[i])) {
						answer[answerIndex++] = i;
					}
				}
				start += 7;
			}
			int odd = 0;
			int even = 0;
			for(int i = 1; i < 9; i++) {
				if(i%2 == 0) even += answer[i];
				else odd += answer[i];
			}
			sb.append("#").append(tc).append(" ");
			if((odd*3+even)%10 == 0) sb.append(odd+even);
			else sb.append(0);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
