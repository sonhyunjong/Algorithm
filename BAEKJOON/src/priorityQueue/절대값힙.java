package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 절대값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int result = Math.abs(o1) - Math.abs(o2);
				
				if(result == 0) return o1 - o2;	//절대 값이 같을때 
				else return result;
			}
		});	//우선순위 큐로 최소 힙
		
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
