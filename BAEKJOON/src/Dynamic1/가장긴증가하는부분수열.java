package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
	static int[] A;
	static int[] dp;

	public static void function() {
        for(int i=0; i<A.length ; i++){
            for(int j=0 ; j<=i ; j++){
                if(A[j]<A[i] && dp[j]>=dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		function();
		
		int max = 0;
		for(int i = 0; i<dp.length; i++) {
			if(max<dp[i]) max = dp[i];
		}
		
		System.out.println(max);
	}
}
