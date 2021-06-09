package Dynamic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전 {
	static int[] dp;
	static int[] coin;
	
	public static void function(int N, int M) {
		dp[0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=coin[i]; j<=M; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	//테스트 케이스 갯수
		int N = 0, M = 0;
		for(int i=0; i<T; i++) {
			dp = new int[10005];
			coin = new int[21];
			
			N = Integer.parseInt(br.readLine());	//동전의 가지수
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=1; j<=N; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());	//만들어야하는 금액
			
			function(N, M);
			
			sb.append(dp[M]+"\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
