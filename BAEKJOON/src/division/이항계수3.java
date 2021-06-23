package division;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class 이항계수3 {
	final static long P = 1000000007;
	 
	//!
	public static long factorial(long N) {
		long fac = 1L;
		
		for(long i=N; i>1; i--) {
			fac = (fac * i) % P;
		}
		return fac;
	}
	
	//역원 
	public static long pow(long denom, long expo) {
		long BePow = 1;
		
		while(expo > 0) {
			if(expo%2 == 1) BePow = (BePow*denom)%P;	// 지수가 홀수 일때 한번더 곱해주기
			denom = (denom*denom)%P;
			expo/=2;	
		}
		return BePow;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		// 분자 N!
		long numer = factorial(N);
	
		// 분모 (K! * (N-K)!) mod p
		long denom = factorial(K) * factorial(N - K) % P;	
	
		// N! * 분모의 역원((K! * (N-K)!) 
		System.out.println(numer * pow(denom, P - 2) % P);
		
	}
	
}
