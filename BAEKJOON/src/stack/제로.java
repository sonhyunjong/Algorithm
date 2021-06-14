package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 제로 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void ZERO(int N) {
		if(N == 0) {
			list.remove(list.size()-1);
		}else {
			list.add(N);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 
		 int K = Integer.parseInt(br.readLine());
		 
		 for(int i=0; i<K; i++) {
			 int N = Integer.parseInt(br.readLine());
			 ZERO(N);
		 }
		 
		 int sum = 0;
		 for(int i=0; i<list.size(); i++) {
			 sum += list.get(i);
		 }
		 System.out.println(sum);
	}
}
