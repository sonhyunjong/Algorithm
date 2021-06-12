package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {
	 static String[] sub;
	 
	 public static int function() {
		 int result = 0;
		 
		 for(int i=0; i<sub.length; i++) {
			 int sum = 0;
			 String[] add = sub[i].split("\\+");	//+ 기준으로 문자열 나누기
			 
			 for(int j=0; j<add.length; j++) {
				 sum += Integer.parseInt(add[j]);	//+ 기준으로 나눈 문자열 더하기
			 }
			 
			 if(i==0) result += sum;	//첫번째 문자열 처리
			 else result -= sum;
		 }
		 return result;
	 }
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 sub = br.readLine().split("-");	//-기준으로 문자열 나누기
		 
		 System.out.println(function());
	}
}
