package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
	static Stack<Character> stack = new Stack<Character>();
	static StringBuilder sb = new StringBuilder();
	
	public static void function(String str) {
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)=='('){
				stack.push(str.charAt(i));
			}else {
				if(!stack.empty()) {
					stack.pop();
				}else {	//스택은 비어있는데 ')' 값을 입력 받았을때
					sb.append("NO").append('\n');
					return;
				}
			}
		}
		if(stack.empty()) {
			sb.append("YES").append('\n');
		}else {
			sb.append("NO").append('\n');
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			function(str);
			stack.clear();
		}
		
		System.out.println(sb);
	}

}
