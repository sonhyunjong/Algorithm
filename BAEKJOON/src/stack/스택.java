package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 스택 {
	static ArrayList<Integer> resultStack = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void push(String num) {
		resultStack.add(Integer.parseInt(num));
	}
	public static void pop() {
		if(resultStack.size()==0) {
			sb.append(-1).append('\n');
		}else {
			sb.append(resultStack.get(resultStack.size()-1)).append('\n');
			resultStack.remove(resultStack.size()-1);
		}
	}
	public static void size() {
		sb.append(resultStack.size()).append('\n');
	}
	public static void empty() {
		if(resultStack.size()==0) {
			sb.append(1).append('\n');
		}else {
			sb.append(0).append('\n');
		}
	}
	public static void top() {
		if(resultStack.size() == 0) {
			sb.append(-1).append('\n');
		}else {
			sb.append(resultStack.get(resultStack.size()-1)).append('\n');
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 
		 int N = Integer.parseInt(br.readLine());
		 
		 for(int i=0; i<N; i++) {
			 String stack = br.readLine();
			 if(stack.contains("push")) push(stack.split(" ")[1]);
			 else if(stack.equals("pop")) pop();
			 else if(stack.equals("size")) size();
			 else if(stack.equals("empty")) empty();
			 else if(stack.equals("top")) top();
		 }
		 
		 System.out.println(sb);
		 
		 br.close();
	}

}
