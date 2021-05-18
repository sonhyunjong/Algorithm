package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단어정렬 {

	public static void main(String[] args) throws IOException {
		// 입력 : 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
		// 출력 : 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
		
		//입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<count; i++) {
			String words = br.readLine();
			if(!list.contains(words)) {	//중복된 값은 한번만 출력
				list.add(words);
			}
		}
		
		Collections.sort(list);
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return 0;
				else if( o1.length() > o2.length()) return 1;
				else return -1;
			}
		});

		//출력
		for(int i=0; i<list.size(); i++) {
			bw.write(list.get(i)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
