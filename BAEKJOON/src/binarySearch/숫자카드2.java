package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] target;

	public static int lowerBound(int target) //하한선
	{
		int left = 0;
		int right = arr.length;
		int mid;

		while(left < right)
		{
			mid = (left + right) / 2;

			if(arr[mid] >= target)
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

	public static int upperBound(int target)	//상한선
	{
		int left = 0;
		int right = arr.length;
		int mid;

		while(left < right)
		{
			mid = (left + right) / 2;

			if(arr[mid] <= target)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		target = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<M; i++) {
			sb.append(upperBound(target[i])-lowerBound(target[i])+ " ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
