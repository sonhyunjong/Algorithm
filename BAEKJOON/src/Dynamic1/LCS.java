package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
	static char[] str1;
	static char[] str2;
	static int[][] dp;
	
	public static void LCS() {
		for(int i = 0; i<=str1.length; i++) {
			for(int j = 0; j<=str2.length; j++) {
				
				if(i == 0 || j ==0) dp[i][j] = 0;	//dp 초기 값
				
				else if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1;	// str1, str2가 같을때
				
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 	//다를때
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new int[str1.length + 1][str2.length + 1];
		
		LCS();
		
		System.out.println(dp[str1.length][str2.length]);
	}
}
