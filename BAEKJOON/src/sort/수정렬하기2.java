package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//173908KB 1772ms
public class 수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		//출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 0; i<count; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		br.close();
		Collections.sort(num);
		for(int i = 0; i<count; i++) {
			 bw.write(num.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
