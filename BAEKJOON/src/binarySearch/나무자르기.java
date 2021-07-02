package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {
	static int[] a;
	
	public static int binary(int N) {
		//제일 긴 나무의 중간부터 잘라서 탐색한다 
		int start=1;
		int end = a[a.length-1];
		
		while(start<=end) {
			int mid = (end + start)/2;
			
			long rest=0;
			for(int j=0; j<a.length; j++) {
				if(a[j]-mid>0) rest += a[j]-mid;
            }
			
			if(rest>=N) {
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		a = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);

		System.out.println(binary(M));
	
		br.close();
	}

}
