package Bruteforce;

import java.util.Scanner;

public class Deongchi {

	public static void main(String[] args) {
		//입력 : 첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
		//출력 : 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
		
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		
		int[][] deongchi = new int[count][2];
		int level[] = new int[count];
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < deongchi[i].length; j++) {
				deongchi[i][j] = scanner.nextInt();
			}
		}
		
		//덩치 등수 매기기
		for(int i=0;i<deongchi.length;i++) {
			for(int j=0;j<deongchi.length;j++) {
				if(deongchi[i][0] > deongchi[j][0] && deongchi[i][1] > deongchi[j][1]) {
					level[j]++;
				}
			}
		}
		//출력 
		for(int i = 0; i<count; i++) {
			System.out.print(level[i]+ 1 +" ");
		}
	}
}
