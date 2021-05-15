package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//385268KB 1812ms
public class 수정렬하기3 {

	public static void main(String[] args) throws IOException {
		//입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
		//출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		int[] num = new int[10001];
		int index = 0;
		
		for(int i = 0; i<count; i++) {
			index = Integer.parseInt(br.readLine());
			num[index]++;
		}
		br.close();
		
		for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < num[i]; j++) {
                sb.append(i + "\n");
            }
        }
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
