package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
	static int[] num;
	static int[] dp;
	static int result;

	public static void sum() {
		dp[0] = num[0];
		result = num[0];
		
		for (int i = 1; i < dp.length; i++) {
			
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]); 
			
			result = Math.max(result, dp[i]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		num = new int[N];
		dp = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		sum();
		System.out.println(result);
		
		br.close();
	}

}
