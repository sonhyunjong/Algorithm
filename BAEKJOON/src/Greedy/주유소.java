package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {
	static long[] km;
	static long[] L;
	
	public static long function() {
		long result = 0;
		long minL = L[0];
		
		for(int i=0; i<km.length; i++) {
			if(minL>L[i]) {
				minL = L[i];
			}
			result += minL*km[i];
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//* 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 int N = Integer.parseInt(br.readLine());	//도시의 개수
		 km = new long[N-1];
		 L = new long[N];
		 
		 st = new StringTokenizer(br.readLine());	//도시를 연결하는 도로길이
		 for(int i=0; i<N-1; i++) {
			 km[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 st = new StringTokenizer(br.readLine()); 	//주유소의 리터당 가격
		 for(int i=0; i<N; i++) {
			 L[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 System.out.println(function());
	}

}
