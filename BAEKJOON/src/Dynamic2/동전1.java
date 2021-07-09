package Dynamic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {
	static int[] dp = new int[10005];
	static int[] coin = new int[101];
	
	public static int Dinamic2(int n, int k) {
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		return dp[k];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());	//동전의 종류
		int k = Integer.parseInt(st.nextToken());	//만들고자 하는 금액
		
		for(int i=1; i<=n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
	
		System.out.println(Dinamic2(n, k));	
	}
}
