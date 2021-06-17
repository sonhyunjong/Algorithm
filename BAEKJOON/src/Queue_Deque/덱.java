package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dequeue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(str.contains("push_front")){
				dequeue.offerFirst(Integer.parseInt(str.split(" ")[1]));
			}else if(str.contains("push_back")){
				dequeue.offerLast(Integer.parseInt(str.split(" ")[1]));
			}else if(str.equals("pop_front")){
				if(dequeue.isEmpty()) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dequeue.pollFirst()).append('\n');
				}
			}else if(str.equals("pop_back")){
				if(dequeue.isEmpty()) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dequeue.pollLast()).append('\n');
				}
			}else if(str.equals("size")){
				sb.append(dequeue.size()).append('\n');
			}else if(str.equals("empty")){
				if(dequeue.isEmpty()) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
			}else if(str.equals("front")){
				if(dequeue.isEmpty()) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dequeue.peekFirst()).append('\n');
				}
			}else if(str.equals("back")){
				if(dequeue.isEmpty()) {
					sb.append(-1).append('\n');
				}else {
					sb.append(dequeue.peekLast()).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}
