package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수정렬하기 {

	public static void main(String[] args) throws IOException {
		// 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		// 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(br.readLine());
			if(!list.contains(num)) {	//입력 값 중 같은 숫자는 list에 추가되지 않음 
				list.add(num);
			}
		}
		//정렬
		Collections.sort(list);
		
		for(int i=0; i<count; i++) {
			bw.write(list.get(i)+"\n");
		}
		//출력
		br.close();
		bw.flush();
		bw.close();
	}
}
