package Queue_Deque;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
 
public class AC {
 
	public static Scanner in = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true;	
	
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;	// 방향을 바꿔줌
				continue;
			}

			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}
			else {
				// 만약 반환 된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		toString(deque, isRight);
	}
	
	public static void toString(ArrayDeque<Integer> deque, boolean isRight) {
		
		sb.append('[');	
		
		if(deque.size() > 0) {
			
			if(isRight) {	// 정방향일경우 
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {	// 역방향일경우 
				sb.append(deque.pollLast());	

				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append('\n');
	}
	
	public static void main(String[] args) {
		ArrayDeque<Integer> deque;
		StringTokenizer st;
	
		int T = in.nextInt();
		
		while(T --> 0) {
			String command = in.next();	
			int n = in.nextInt();
			
			st = new StringTokenizer(in.next(), "[],");
			deque = new ArrayDeque<Integer>();

			for(int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deque);
		}
		System.out.println(sb);
	}
}