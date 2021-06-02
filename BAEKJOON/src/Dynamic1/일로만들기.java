package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
	static Integer[] dp;
	
	public static int to1(int X) {
		if(dp[X] == null) {
			if(X%6 == 0) dp[X] = Math.min(to1(X - 1), Math.min(to1(X / 3), to1(X / 2))) + 1;
			else if(X%3 == 0) dp[X] = Math.min(to1(X / 3), to1(X - 1)) + 1;
			else if(X%2 == 0) dp[X] = Math.min(to1(X / 2), to1(X - 1)) + 1;
			else dp[X] = to1(X-1) + 1;  
		}
		return dp[X];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		dp = new Integer[X+1];
		dp[0] = dp[1] = 0;
		
		System.out.println(to1(X));
		
		br.close();
	}
}
