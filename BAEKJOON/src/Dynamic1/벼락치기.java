package Dynamic1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 벼락치기 {
	static int N, T;
    static int[] time;
    static int[] score;
    static int[][] dp;
    
    public static void function() {
        for(int i = 1; i <= N; i++) {
            for(int p = 0; p <= T; p++) {
                if(p - time[i] < 0) dp[i][p] = dp[i-1][p];
                else dp[i][p] = Math.max(dp[i-1][p], dp[i-1][p-time[i]] + score[i]);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        time = new int[N+1];
        score = new int[N+1];
        dp = new int[N+1][T+1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        function();
        
        System.out.println(dp[N][T]);
    }
}
