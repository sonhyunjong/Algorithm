package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 큐2 {
	//큐 : FIFO 덱: 양쪽 FIFO
	static Deque<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void push(String str) {
		queue.offer(Integer.parseInt(str));
	}
	public static void pop() {
		if(queue.isEmpty()) {
			sb.append(-1).append('\n');
		}else {
			Integer pop = queue.poll();
			sb.append(pop).append('\n');
		}
	}
	public static void size() {
		sb.append(queue.size()).append('\n');
	}
	public static void empty() {
		if(queue.isEmpty()) {
			sb.append(1).append('\n');
		}else {
			sb.append(0).append('\n');
		}
		
	}
	public static void front() {
		if(queue.isEmpty()) {
			sb.append(-1).append('\n');
		}else {
			Integer front = queue.peek();
			sb.append(front).append('\n');
		}
	}
	public static void back() {
		if(queue.isEmpty()) {
			sb.append(-1).append('\n');
		}else {
			Integer back = queue.peekLast(); //Queue는 인덱스 값으로 값을 설정할 수 없다.
			sb.append(back).append('\n');
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(str.contains("push")) push(str.split(" ")[1]);
			 else if(str.equals("pop")) pop();
			 else if(str.equals("size")) size();
			 else if(str.equals("empty")) empty();
			 else if(str.equals("front")) front();
			 else if(str.equals("back")) back();
		}
		
		System.out.println(sb);
	}
}
