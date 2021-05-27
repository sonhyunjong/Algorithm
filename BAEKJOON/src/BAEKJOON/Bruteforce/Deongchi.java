package BAEKJOON.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deongchi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력 : 첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
		//출력 : 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		int[][] deongchi = new int[count][2];
		int level[] = new int[count];
		String[] sp;
		
		//입력
		for(int i = 0; i < count; i++) {
			sp = br.readLine().split(" ");			
			deongchi[i][0] = Integer.parseInt(sp[0]);	 
			deongchi[i][1] = Integer.parseInt(sp[1]);	
		}
		
		//덩치 등수 매기기  -> 나보다 키, 몸무게 작은 사람 +1
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
		
		br.close();
	}
}
