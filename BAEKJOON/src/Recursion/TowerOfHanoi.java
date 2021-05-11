package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void towerOfHanoi(int num, int start, int mid, int to) {
		
		if(num ==1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// 1. num-1개 1에서 2로 이동()
		// 2. 1개 1에서 3으로 이동 <>
		// 3. num-1개 2에서 3으로 이동[]
		towerOfHanoi(num-1, start, to , mid);//(2,1,3,2)/(1,1,2,3)/[1,2,3,1]
		
		sb.append(start + " " + to + "\n");//<3,1,2,3>
		
		towerOfHanoi(num-1, mid, start, to);//(1,3,1,2)/[2,2,1,3]/[1,1,2,3]
		
	}

	public static void main(String[] args) {
		//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
		//입력 : 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
		//출력 : 첫째 줄에 옮긴 횟수 K를 출력한다. 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		sb.append((int)(Math.pow(2, num)-1)).append('\n');//2^n-1
		
		towerOfHanoi(num, 1, 2, 3);
		
		System.out.println(sb);
	}

}
