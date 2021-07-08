package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());	//최소 힙
		Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());	//최대 힙
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
    		int input = Integer.parseInt(br.readLine());
    		
    		if(minQueue.size() == maxQueue.size()) maxQueue.offer(input);
    		else minQueue.offer(input);
    		
    		if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
    			if(minQueue.peek() < maxQueue.peek()) {	//새로들어온 값을 minQueue.peek()과 비교해서 swap => 정렬
    				int tmp = minQueue.poll();
    				minQueue.offer(maxQueue.poll());
    				maxQueue.offer(tmp);
    			}
    		}
    		sb.append(maxQueue.peek() + "\n");
    	}
		System.out.println(sb);
		
		br.close();
	}

}
