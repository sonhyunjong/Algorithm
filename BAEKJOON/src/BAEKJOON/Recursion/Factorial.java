package BAEKJOON.Recursion;

import java.util.Scanner;

public class Factorial {
	
	public static int factorial(int num) {
		int result = 0;
		
		if(num == 0) {
			return 1;
		}else {
			result = num * factorial(num-1);
		}
		return result;
	}

	public static void main(String[] args) {
		//0보다 크거나 같은 정수 N이 주어진다. N!을 출력하는 프로그램을 작성하시오.
		//입력 : 첫째 줄에 정수(0<=N<=12)가 주어진다.
		//출력 : 첫째 줄에 N!을 출력한다.
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int result = factorial(num);
		
		System.out.println(result);
	}
}
