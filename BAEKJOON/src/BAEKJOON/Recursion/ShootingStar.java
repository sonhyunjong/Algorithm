package BAEKJOON.Recursion;


import java.util.Scanner;

public class ShootingStar {
	static char[][] arr;
	
	public static void shootingStar(int x, int y, int num, boolean blank) {
		if(blank) {	// 공백일 경우
			for(int i = x; i < x + num; i++) {
				for(int j = y; j < y + num; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if(num == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = num/3;
		int count = 0;
		for(int i = x; i < x + num; i += size) {
			for(int j = y; j < y + num; j+=size) {
				count++;
				
				if(count == 5) {
					shootingStar(i, j, size, true);
				}else {
					shootingStar(i, j, size, false);
				}
			}
		}
	}

	public static void main(String[] args) {
		//재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
		//N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
		//입력 : z첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
		//출력 : 첫째 줄부터 N번째 줄까지 별을 출력한다.
		
		//슈발 모르겠음
	
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		arr = new char[num][num];
		
		shootingStar(0, 0, num, false);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
