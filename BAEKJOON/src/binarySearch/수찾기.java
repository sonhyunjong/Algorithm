package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
	static int[] A;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static int binary(int target) {
		int start = 0;
		int end = A.length-1;
		int mid = (end + start)/2;
		
		while(end - start >= 0) {
			if(A[mid] == target) {
				return 1;
			}else if(A[mid] <= target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			mid = (end + start)/2;
		}
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		for(int i=0; i<M; i++) {
			sb.append(binary(arr[i]) + "\n");
		}
		
		System.out.println(sb);
	}
}
