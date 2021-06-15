package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	static Stack<Integer> stack = new Stack<>();
	static int result[];
	static StringBuilder sb = new StringBuilder();
	
	public static void function() {
		for(int i = 0; i <result.length; i++) {
			
			while(!stack.isEmpty() && result[stack.peek()] < result[i]) {	//기준 값 바로 다음수에 큰 값이 있을때
				result[stack.pop()] = result[i]; 
			}
			stack.push(i);	//기준 값은 스택에 저장해서 비교한다
		}
		
		while(!stack.isEmpty()) {	//비교할 값이 없을떄 (스택이 비었을때)
			result[stack.pop()] = -1;
		}
		
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(' ');
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result = new int[N];
		for(int i=0; i<N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		function();
		System.out.println(sb);
	}
}
