package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 통계학 {

	public static void main(String[] args) throws IOException {
		// 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
		/* 출력 : 
		 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다. 
		 * 둘째 줄에는 중앙값을 출력한다.
		 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		 * 넷째 줄에는 범위를 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());//홀수
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 0; i<count; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		//1. 산술평균 (반올림)
		double sum = 0;
		for(int i=0; i<num.size(); i++) {
			sum +=num.get(i);
		}
		sb.append(Math.round(sum/num.size())+"\n");
		
		//2. 중앙값
		Collections.sort(num);
		sb.append(num.get(num.size()/2)+"\n");
		
		//3. 최빈값 
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<num.size(); i++) {
			if(map.get(num.get(i)) == null) {
				map.put(num.get(i), 1);
			}else {
				map.put(num.get(i), map.get(num.get(i)) + 1);
			}
		}
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList);//map key(입력 숫자) 기준 오름차
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));// map value(횟수) 기준 내림차
//		Collections.sort(keySetList, new Comparator<string>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return map.get(o2).compareTo(map.get(o1));
//            }
//        });
		
		if( keySetList.size() == 1) {	//하나만 입력했을때
			sb.append(keySetList.get(0)+"\n");
		}else if(map.get(keySetList.get(0)) != map.get(keySetList.get(1))) {	//빈도수 중복이 아닐때
			sb.append(keySetList.get(0)+"\n");
		}else {
			sb.append(keySetList.get(1)+"\n");	//빈도수 중복일때
		}

		//4. 범위 (최대- 최소)
		sb.append(Collections.max(num)-Collections.min(num)+"\n");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
