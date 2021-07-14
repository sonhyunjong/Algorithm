package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
	static StringBuilder sb = new StringBuilder();
	static int[][] check;
	static boolean[][] checked;
	static int count = 1;
	static int x[] = {-1, 1, 0, 0}; // row
	static int y[] = {0, 0, -1, 1}; // col
	static int N = 0, M =0;
	
	public static void DFS(int i, int j) {
		check[i][j] = count;
		checked[i][j] = true;
		
		for(int k=0; k<4; k++) { 	//상하좌우 이동
			int X = i + x[k];
			int Y = j + y[k];
			
			if(X >= 0 && X < M && Y >= 0 && Y < N) {
				if(check[X][Y] == 1 && !checked[X][Y]) {
					DFS(X, Y);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		//입력
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());	//배추를 심은 배추밭의 가로길이
			N = Integer.parseInt(st.nextToken());	//배추를 심은 배추밭의 세로길이
			int K = Integer.parseInt(st.nextToken());	//배추가 심어져 있는 위치의 개수
			
			check = new int[M][N];
			checked = new boolean[M][N];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				check[x][y] = 1;
			}
			
			for(int a=0; a<M; a++) {
				for(int b=0; b<N; b++) {
					if(check[a][b] == 1 && !checked[a][b]) {
						DFS(a,b);
						count++;
					}
				}
			}
			sb.append(count-1);
			sb.append("\n");
			count = 1;
		}
		
		//츨력
		System.out.println(sb);
		
		br.close();
	}
}
