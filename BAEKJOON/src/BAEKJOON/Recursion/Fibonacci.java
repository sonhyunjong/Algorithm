package BAEKJOON.Recursion;

import java.util.Scanner;

public class Fibonacci {
	
	public static int fibonacci(int num) {
		int result = 0;
		
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}else {
			result = fibonacci(num-1)+fibonacci(num-2);
		}
		return result;
	}

	public static void main(String[] args) {
		//n이 주어졌을때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
		//입력 : 첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
		//출력 : 첫째 줄에 n번째 피보나치 수를 출력한다.
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int result = fibonacci(num);
		
		System.out.println(result);
	}
}
