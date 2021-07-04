package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	static int[] arr;
	
	public static int binary(int C) {	//거리를 이분탐색
		int result = 0;
		int start = 1;
		int end = arr[arr.length-1] - arr[0];
		int distance = 0;
		
		while(start <= end) {
			int mid = (end + start) / 2;
			int house = arr[0];
			int count = 1;
			
			for (int i = 0; i < arr.length; i++) {
				distance = arr[i] - house;  
                if (distance >= mid) {  
                    count++;
                    house = arr[i]; 
                }
            }
			
			if(count >= C) {
				start = mid + 1;
				result = mid;
			}else {
				end = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.println(binary(C));

		br.close();
	}

}
