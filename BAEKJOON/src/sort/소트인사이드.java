package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class 소트인사이드 {

	public static void main(String[] args) throws IOException {
		// 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
		// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0; i<N.length(); i++) {
			list.add(N.charAt(i)+"");
		}
		Collections.sort(list,Comparator.reverseOrder());
		
		for(int i=0; i<N.length(); i++) {
			sb.append(list.get(i));
		}
	
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
