package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드 {
	static Queue<Integer> queue = new LinkedList<>();
	
	public static int card() {
		
		while(queue.size() > 1) {
			
			queue.poll();	//pop
			
			int n = queue.peek();
			queue.poll();	//pop
			queue.offer(n);	//push
		}
		
		return queue.peek();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		System.out.println(card());
	}
}
