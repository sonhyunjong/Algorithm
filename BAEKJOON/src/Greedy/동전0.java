package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {
	static int[] coins;
	
	public static int greedyCoins(int K) {
		int result = 0 ;
		for(int i=coins.length-1; i>-1; i--) {
			if(K/coins[i]>0) {
				result += K/coins[i];
				K = K%coins[i];
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());    //동전의 종류 갯수
		int K = Integer.parseInt(st.nextToken());	 //목표 금액
		
		coins = new int[N];
		
		for(int i=0; i<coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(greedyCoins(K));
		
		br.close();
	}
}
