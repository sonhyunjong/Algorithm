package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스 {
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void Josephus(int K) {
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			if(queue.size() == 1) sb.append(queue.poll()).append(">");
			else sb.append(queue.poll()).append(", ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		Josephus(K);
		
		System.out.println(sb);
	}
}
