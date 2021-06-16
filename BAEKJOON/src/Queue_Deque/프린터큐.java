package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐 {
	static StringBuilder sb = new StringBuilder();
	static LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용 할 연결리스트
	
	public static void function(int findIndex) {
		int count = 0;  //findindex를 출력하기 까지 횟수
		
		while (!q.isEmpty()) {
			
			int[] front = q.poll();	
			boolean isMax = true;	
			
			for(int i = 0; i < q.size(); i++) {
				if(front[1] < q.get(i)[1]) {

					q.offer(front);
					for(int j = 0; j < i; j++) {
						q.offer(q.poll());
					}
					isMax = false;
					break;
				}
			}
			if(isMax == false) {
				continue;
			}
			count++;
			if(front[0] == findIndex) {
				break;
			}

		}
		sb.append(count).append('\n');
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int findIndex = 0;
		
		int N = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			findIndex = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
 
			for (int j = 0; j < n; j++) {
				q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });	//{인덱스, 중요도}
			}
			function(findIndex);
			q.clear();
		}
		System.out.println(sb);
		
	}
}
