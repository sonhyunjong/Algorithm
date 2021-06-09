package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	static int[][] array;
	   static int n ;
	   static int k;
	   
	   static int maxValue;
	   public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st;
		  st = new StringTokenizer(br.readLine(), " ");
		  
	      n = Integer.parseInt(st.nextToken());
	      k = Integer.parseInt(st.nextToken());
	      
	      array = new int[n+1][2];
	      
	      for(int i=0; i<n; i++) {
	    	 st = new StringTokenizer(br.readLine(), " ");
	         array[i+1][0] = Integer.parseInt(st.nextToken()); 
	         array[i+1][1] = Integer.parseInt(st.nextToken()); 
	      }
	      
	      int[][] mDPArray = new int[n+1][k+1];
	      
	      for(int i=1; i<=n; i++ ) { 
	         for(int j=1; j<=k; j++) { 
	            mDPArray[i][j] = mDPArray[i-1][j]; 
	            
	            if(j-array[i][0] >= 0) { 
	               mDPArray[i][j] = Math.max(mDPArray[i-1][j], mDPArray[i-1][j-array[i][0]]+array[i][1]);
	            }
	         }
	      }
	      System.out.println(mDPArray[n][k]);
	   }

}
