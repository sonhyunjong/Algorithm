package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {
	static long[] a;
	
	public static long binary(int N) {
		//제일 긴 랜선을 중간부터 잘라서 갯수를 확인한다 (이분탐색)
		long start=1;
		long end = a[a.length-1];
		
		while(start<=end) {
			long mid = (end + start)/2;
			
			int count=0;
			for(int j=0; j<a.length; j++) {
				count += a[j]/mid;
            }
			
			if(count>=N) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return end;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		a = new long[K];
		
		for(int i=0; i<K; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a);

		System.out.println(binary(N));
	
		br.close();
	}

}
