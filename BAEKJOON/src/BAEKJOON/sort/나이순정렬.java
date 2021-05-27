package BAEKJOON.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 나이순정렬 {

	public static void main(String[] args) throws IOException {
		/*
		 * 입력 : 
		 * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
		 * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 
		 * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 
		 * 입력은 가입한 순서로 주어진다.
		 * 
		 * 출력 : 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
		 */
		//입력 : 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<N; i++){
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] o1Arr = o1.split(" ");
				String[] o2Arr = o2.split(" ");
				return Integer.parseInt(o1Arr[0])-Integer.parseInt(o2Arr[0]);
			}
		});
		
		for(int i=0; i<N; i++){
			sb.append(list.get(i)+"\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	
	}
}
