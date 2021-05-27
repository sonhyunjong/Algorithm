package BAEKJOON.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Blackjack {

	public static void main(String[] args) throws IOException {
		//입력 : 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다. 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
		//출력 : 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp;
		sp = br.readLine().split(" ");
		
		int count = Integer.parseInt(sp[0]);
		int max = Integer.parseInt(sp[1]);
		List<Integer> num = new ArrayList<Integer>();
		sp = br.readLine().split(" ");
		
		for(int i = 0; i<count; i++) {
			num.add(Integer.parseInt(sp[i]));
		}
		
		// 
		int result =0;
		for(int i =0; i<count-2; i++) {
			for(int j = i+1; j<count-1; j++) {
				for(int k = j+1; k<count; k++) {
					if(num.get(i)+num.get(j)+num.get(k)<=max && num.get(i)+num.get(j)+num.get(k)>result) {
						result = num.get(i)+num.get(j)+num.get(k);
					}
				}
			}
		}
	
		//출력
		System.out.println(result);
		br.close();
	}
}
