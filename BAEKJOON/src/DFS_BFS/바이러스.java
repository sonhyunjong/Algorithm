package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
	//DFS : 이동시 가중치가 붙거나 제약이 있을때 유리
	//BFS : 최단거리 구현에 유리
	static int[][] check = new int[101][101]; //DFS 입접행렬
	static boolean[] checked = new boolean[101];
	static int count = 0;	//감염된 컴퓨터 수
	
	public static void DFS(int N, int V) {
		if(checked[V]==true) return;
		
		checked[V] = true;
		count++;
		
		for(int i=1; i<=N; i++) {
			if(check[V][i] == 1 && checked[i] == false) {
				DFS(N, i);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //정점의 개수
		int M = Integer.parseInt(br.readLine()); //간선의 개수
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			check[x][y] = check[y][x] = 1;
		}
		
		DFS(N, 1);
		
		System.out.println(count-1);//1번은 제외해야함
	}
}
