package Solution;

import java.io.*;
import java.util.*;


public class swea1244 {
	static int change, maxNum;
	static char[] numbers;
	static Set<String> visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());	// 테스트케이스 개수
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = st.nextToken().toCharArray();
			change = Integer.parseInt(st.nextToken());
			maxNum = 0;
			visited = new HashSet<>();
			DFS(0);
			bw.write("#" + t + " " + maxNum + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void DFS(int depth) {
		if(depth == change) {
			String result = "";
			for(char c : numbers) {
				result += c;
			}
			int resultNum = Integer.parseInt(result);
			maxNum = Math.max(maxNum, resultNum);
		}else {
			for(int i = 0; i < numbers.length; i++) {
				for(int j = i+1; j < numbers.length; j++) {
					changeNum(i,j);
					if(!visited.contains(new String(numbers)+depth)) {
						visited.add(new String(numbers)+depth);
						DFS(depth+1);
					}
					changeNum(i,j);
				}
			}
		}
	}
	static void changeNum(int i, int j) {
		char tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}






