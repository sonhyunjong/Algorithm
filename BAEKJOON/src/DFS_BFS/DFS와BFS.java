package DFS_BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
	static int[][] check = new int[1001][1001]; //DFS 입접행렬
	static Queue<Integer> queue = new LinkedList<Integer>(); //BFS 큐
	static boolean[] checked = new boolean[1001];
	static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int N, int V) {
		checked[V] = true;
		sb.append(V + " ");
		
		for(int i=1; i<=N; i++) {
			if(check[V][i] == 1 && checked[i] == false) {
				DFS(N, i);
			}
		}
	}
	public static void BFS(int N, int V) {
		queue.offer(V);
		checked[V] = true;
		sb.append(V + " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(check[temp][i] == 1 && checked[i] == false) {
					queue.offer(i);
			        checked[i] = true;
			        sb.append(i + " ");
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			check[x][y] = check[y][x] = 1;
		}
		
		DFS(N,V);
		
		checked = new boolean[1001]; //확인상태 초기화
		sb.append("\n");
		
		BFS(N,V);
		
		System.out.println(sb);
	}
}
