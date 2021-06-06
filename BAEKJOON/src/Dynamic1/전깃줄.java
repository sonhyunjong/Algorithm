package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄 {
	static int[][] w;	//전깃줄
	static int[] dp;
	public static void wCount() {
		for (int i = 0; i < dp.length; i++){
			dp[i] = 1;
		    for (int j = 0; j < i; j++){
		        if(w[j][1] < w[i][1]){
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }        
		    }
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		dp = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w[i][0] = Integer.parseInt(st.nextToken());
			w[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(w, new Comparator<int[]>() { 	//A 기준 정렬 
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		wCount();
		
		int max = 0;
		
		for(int i=0; i<N; i++) {
			if(max<dp[i]) max = dp[i];
		}
		
		System.out.println(N-max);
		
	}

}
