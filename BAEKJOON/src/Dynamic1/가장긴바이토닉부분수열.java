package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {
	static int[] S;
	static int[] dp_LIS;
	static int[] dp_LDS;
	
	public static void LIS() {
		for (int i = 0; i < dp_LIS.length; i++){
			dp_LIS[i] = 1;
		    for (int j = 0; j < i; j++){
		        if(S[j] < S[i]&& dp_LIS[i] < dp_LIS[j] + 1){
		        	dp_LIS[i] = dp_LIS[j] + 1;
		        }        
		    }
		}
	}
	public static void LDS() {
		for (int i = dp_LDS.length-1; i >= 0; i--){
			dp_LDS[i] = 1;
		    for (int j = dp_LDS.length-1; j > i; j--){
		        if(S[j] < S[i]&& dp_LDS[i] < dp_LDS[j] + 1){
		        	dp_LDS[i] = dp_LDS[j] + 1;
		        }        
		    }
		}
	}
	
	public static int MAX() {
		int max = 0;
		for(int i=0; i<S.length; i++) {
			if(max < dp_LIS[i] + dp_LDS[i]) max = dp_LIS[i] + dp_LDS[i];
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		S = new int[N];
		dp_LIS = new int[N];
		dp_LDS = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken()); 
		}
		LIS();
		LDS();
		System.out.println(MAX()-1);
	}

}
