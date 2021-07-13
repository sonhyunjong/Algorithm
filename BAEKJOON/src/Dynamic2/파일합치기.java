package Dynamic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일합치기 {
	static int[] file;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static int Sum(int[] sum, int start, int end) {
		if(start == 0) {
			return sum[end];
		}else {
			return sum[end] - sum[start-1];
		}
	}
	public static void solution() {
		int[] sum = new int[file.length];
		
		sum[0] = file[0];
		
		for(int i=1; i<sum.length; i++) {
			sum[i] = sum[i-1] + file[i];
		}
		for(int i=0; i<file.length-1; i++) {
			dp[i][i+1] = file[i] + file[i+1];
		}
		
		for(int j=2; j<file.length; j++) {
			for(int i=0; i+j<file.length; i++) {
				for(int k=i; k<i+j; k++) {
					if(dp[i][i+j] == 0) {
						dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + Sum(sum, i, i+j);
					}else {
						dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + Sum(sum, i, i+j));
					}
				}
			}
		}
		sb.append(dp[0][file.length-1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st;
	     
	     int T = Integer.parseInt(br.readLine());	//테스트 케이스 갯수
	     
	     for(int i=0; i<T; i++) {
	    	 int K = Integer.parseInt(br.readLine());
	    	 st = new StringTokenizer(br.readLine(), " ");
	    	 file = new int[K];
	    	 dp = new int[K][K];
	    	 
	    	 for(int j=0; j<K; j++) {
	    		 file[j] = Integer.parseInt(st.nextToken());
	    	 }
	    	 solution();
	    	 sb.append("\n");
	     }
	     
	     System.out.println(sb);
	     
	     br.close();
	}
}
