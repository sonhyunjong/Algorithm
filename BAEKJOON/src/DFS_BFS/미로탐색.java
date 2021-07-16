package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int[] x = {1,-1,0,0};
    static int[] y = {0,0,-1,1};
    static boolean[][] checked;
    static int[][] check;
    static int N,M;
    
    public static class Points{
		int x;
		int y;
		Points(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
    public static void bfs(int i, int j){
        Queue<Points> q = new LinkedList<>();
        q.offer(new Points(i, j));

        while(!q.isEmpty()){
            Points point = q.poll();
            checked[i][j] = true;

            for(int dir = 0; dir<4; dir++){
                int r = point.x + x[dir];
                int c = point.y + y[dir];

                if(r >= 0 && c >= 0 && r < N && c < M){
                    if(check[r][c] != 0 && !checked[r][c]){
                        q.offer(new Points(r, c));
                        checked[r][c] = true;
                        check[r][c] = check[point.x][point.y] + 1; //다음칸에 탐색한 칸까지의 가중치(+1)를 더해줌
                    }
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                check[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(check[N-1][M-1]);
    }
}
