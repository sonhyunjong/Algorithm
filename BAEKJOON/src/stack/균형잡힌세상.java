package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	static Stack<Character> stack = new Stack<Character>();
	static StringBuilder sb = new StringBuilder();
	
	public static void function(String str) {
	for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)=='(' || str.charAt(i)=='['){
				stack.push(str.charAt(i));
			}else if(str.charAt(i)==')'){
				if(!stack.empty() && stack.peek()=='(') {	//peek 최상위값 
					stack.pop();
				}else {	
					sb.append("no").append('\n');
					return;
				}
			}else if(str.charAt(i)==']'){
				if(!stack.empty() && stack.peek()=='[') {
					stack.pop();
				}else {	
					sb.append("no").append('\n');
					return;
				}
			}
		}
		if(stack.empty()) {
			sb.append("yes").append('\n');
		}else {
			sb.append("no").append('\n');
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			function(str);
			stack.clear();
		}
		System.out.println(sb);
	}
}
