package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void binary(int value) {
		int start = 0;
		int end = list.size() - 1;
		
		while(start < end) {
			int mid = (end + start)/2;
			
			if(value <= list.get(mid)) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		list.set(end, value);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		list.add(0);
		
		int value = 0;
		for(int i=0; i<N; i++) {
			value = Integer.parseInt(st.nextToken());
			
			if(value > list.get(list.size()-1)) {
				list.add(value);
			}else {
				binary(value);
			}
		}
		
		System.out.println(list.size()-1);

	}

}
