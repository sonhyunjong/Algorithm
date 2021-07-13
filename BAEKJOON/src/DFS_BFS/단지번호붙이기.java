package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단지번호붙이기 {
	static int[][] check;
	static boolean[][] checked;
	static int count = 1;
	static int x[] = {-1, 1, 0, 0}; // row
	static int y[] = {0, 0, -1, 1}; // col
	
	public static void DFS(int i, int j) {
		check[i][j] = count;
		checked[i][j] = true;
		
		for(int k=0; k<x.length; k++) { 	//상하좌우 이동
			int X = i + x[k];
			int Y = j + y[k];
			
			if(X >= 0 && X < check.length && Y >= 0 && Y < check.length) {
				if(check[X][Y] == 1 && !checked[X][Y]) {
					DFS(X, Y);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		check = new int[N][N];
		checked = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String arr = br.readLine();
			for(int j=0; j<N; j++) {
				check[i][j] = arr.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] == 1 && !checked[i][j]) {
					DFS(i,j);
					count++;
				}
			}
		}
		
		//출력
		System.out.println(count-1);
		
		int result[] = new int[count];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] != 0) {
					result[check[i][j]]++;
				}
			}
		}
		
		Arrays.sort(result);
		
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
