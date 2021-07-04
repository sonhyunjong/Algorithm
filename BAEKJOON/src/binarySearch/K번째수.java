package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수 {
	
	public static long binary(int N, int K) {	//임의로 선택할 수는 몇번째인가를 이분탐색
		long result = 0;
		
		long start = 1;
		long end = K;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long count = 0;	//mid 보다 작거나 같은 수 
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid / i, N);
			}
			
			if(count < K) {
				start = mid + 1;
			}else {
				result = mid;
				end = mid - 1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		System.out.println(binary(N, K));
	}

}
