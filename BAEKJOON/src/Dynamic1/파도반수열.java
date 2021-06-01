package Dynamic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 파도반수열 {
	static long[] N = new long[101];
	
	public static long pFuntion(int n) {
		if(N[n] == 0) {	
			N[n] = pFuntion(n - 2) + pFuntion(n - 3);
		}
		return N[n];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		N[0]=0L;
		N[1]=1L;
		N[2]=1L;
		N[3]=1L;
		
		for(int i=0; i<T; i++) {
			sb.append( pFuntion(Integer.parseInt(br.readLine())) + "\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
}
