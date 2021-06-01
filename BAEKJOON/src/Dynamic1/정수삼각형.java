package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
	static int[][] tri;
	static int[][] dp;
	
	public static int triMax(int hindex, int windex) {
		
		if(dp[hindex][windex] == 0 && hindex<tri.length-1) {
			dp[hindex][windex] = Math.max(triMax(hindex+1, windex), triMax(hindex+1, windex+1)) + tri[hindex][windex];
		}
		return dp[hindex][windex];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tri = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
				if(i == N-1) {
					dp[i][j] = tri[i][j];
				}
			}
		}
		System.out.println(triMax(0,0));	
		
		br.close();
	}
}
