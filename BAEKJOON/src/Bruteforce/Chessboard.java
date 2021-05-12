package Bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chessboard {
	public static char[][] chess;
	public static int min = 64;
	
	public static void find(int x, int y) {
		//다시 칠해야하는 정사각형 개수의 최솟값 찾기
		int count=0;
		char[] WB = {'W', 'B'};
		char tempWB;
		
		for(int i=x; i<x + 8; i++) {
			for(int j=y; j<y + 8; j++) {
				if(chess[i][j] != WB[(j+1)%2]) {
					count++;
				}
			}
			tempWB = WB[0];
			WB[0] = WB[1];
			WB[1] = tempWB;
		}
		count = Math.min(count, 64 - count); //첫번째가 W인 값과 B인 값의 최소 count 찾기 (최대 64)
		min = Math.min(min, count);// 8*8 체스판 중 count가 최소인 값 
	}

	public static void main(String[] args) throws IOException {
		// 입력 : 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
		// 출력 : 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp;
		sp = br.readLine().split(" ");
		
		int N = Integer.parseInt(sp[0]);
		int M = Integer.parseInt(sp[1]);
		
		chess = new char[N][M];
		String temp;

		for(int i=0; i<N; i++) {
			temp =  br.readLine();
			for(int j=0; j<M; j++) {
				chess[i][j] = temp.charAt(j);
			}
		}
		//계산
		for (int i = 0; i <  N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				find(i, j);
			}
		}
		
		//출력
		System.out.println(min);
	}
}

