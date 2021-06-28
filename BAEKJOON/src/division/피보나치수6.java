package division;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 피보나치수6 {
	final static long MOD = 1000000007;
	public static long[][] origin = {{1, 1} , {1, 0}};	// 초기값을 갖고있는 행렬
	
	public static long[][] pow(long[][] A, long exp) {
		if(exp == 1 || exp == 0) return A;	//지수가 1또는 0일때
		
		long[][] ret = pow(A, exp / 2);	//지수 절반으로 분할
		ret = multiply(ret, ret);
		
		if(exp % 2 == 1L) {	//지수가 홀수일때
			ret = multiply(ret, origin);
		}
		
		return ret;
	}
	
	public static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] ret = new long[2][2];
 
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {							
				for (int j = 0; j < 2; j++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] A = {{1, 1} , {1, 0}};
		long N = Long.parseLong(br.readLine());
		
		System.out.println(pow(A, N - 1)[0][0]);
	}
}
