package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ATM {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static int ATM() {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<i+1; j++) {
				result += list.get(j);
			}
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	//사람의 수
		st = new StringTokenizer(br.readLine());	//각 사람의 돈 인출 시간
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		System.out.println(ATM());
	}
}
