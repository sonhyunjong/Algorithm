package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	static void divide(int n, int x, int y) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != arr[y][x]) {
                	sb.append("(");
                	divide(n / 2, x, y);
                	divide(n / 2, x + n / 2, y);
                	divide(n / 2, x, y + n / 2);
                	divide(n / 2, x + n / 2, y + n / 2);
                    sb.append(")");
                    return;
                }
             }
        } 
        sb.append(arr[y][x]);
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++){
			String[] temp = br.readLine().split(""); 
			for(int j=0; j<N; j++) { 
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		divide(N, 0, 0);
		
		System.out.println(sb);
	 
		br.close();
	}
}
