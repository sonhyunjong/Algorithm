package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 좌표압축 {

	public static void main(String[] args) throws IOException {
		//입력 : 첫째 줄에 N이 주어진다. 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
		//출력 : 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> clone = new ArrayList<Integer>(list);
		clone = clone.stream().distinct().collect(Collectors.toList());
		Collections.sort(clone);
		
		for(int i=0; i<N; i++) {
			sb.append(clone.indexOf(list.get(i))+" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
