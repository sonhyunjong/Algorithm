package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
	//static Deque<Integer> dequeue = new LinkedList<>();
	static LinkedList<Integer> dequeue = new LinkedList<Integer>();
	static ArrayList<Integer> arrM = new ArrayList<Integer>();
	
	public static int function(int N) {
		int count = 0;
	
		for(int i=0; i<arrM.size(); i++) {
			if(dequeue.indexOf(arrM.get(i)) <= dequeue.size()/2) {	//반 보다 작을때
				while(dequeue.peekFirst() != arrM.get(i)) {
					dequeue.offerLast(dequeue.pollFirst());	//2번 
					count++;
				}
			}else {	//반보다 클때
				while(dequeue.peekFirst() != arrM.get(i)) {
					dequeue.offerFirst(dequeue.pollLast());	//3번
					count++;
				}
			}
			dequeue.pollFirst();
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	//큐의 크기
		int M = Integer.parseInt(st.nextToken());	//뽑아내려고 하는 수의 개수
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			arrM.add(Integer.parseInt(st.nextToken()));	//뽑아 내려고하는 수의 위치
		}
		for(int i=1; i<N+1; i++) {
			dequeue.add(i);
		}
		
		System.out.println(function(N));
	}
}
