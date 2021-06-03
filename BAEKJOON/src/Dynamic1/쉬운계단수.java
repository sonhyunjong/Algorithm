package Dynamic1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 쉬운계단수 {
	
	static Long[][] dp;
	static int N;
	final static long MOD = 1000000000;
	
	static long recur(int digit, int val) {		
		 
		if(digit == 1) return dp[digit][val];
		
		if(dp[digit][val] == null) {
			if(val == 0) dp[digit][val] = recur(digit - 1 ,1);// val이 0일경우 ->1
			else if(val== 9) dp[digit][val] = recur(digit - 1, 8);// val이 1일경우 ->8
			else dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);	
		}
		return dp[digit][val] % MOD;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1][10];
		
		// 첫번째 자릿수는 1
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		long result = 0;
		
		for(int i = 1; i <= 9; i++) {
			result += recur(N, i);
		}
		System.out.println(result % MOD);
	}
	
}