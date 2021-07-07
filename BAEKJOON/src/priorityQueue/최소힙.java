package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최소힙 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());	//우선순위 큐로 최소 힙
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
    		int input = Integer.parseInt(br.readLine());
    		
    		if(input == 0) {
    			if(queue.isEmpty()) sb.append(0 + "\n");
    			else sb.append(queue.poll() + "\n"); //pop
    		}else {
    			queue.add(input);
    		}
    	}
		System.out.println(sb);
		
		br.close();
	}
}
