package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수 {
	static int[][] arr;
	static int[] count = new int[3];
	
	public static void divide(int n, int x, int y) {
		for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != arr[y][x]) {
                	
                	divide(n/3, x, y); 
                	divide(n/3, x+n/3, y); 
                	divide(n/3, x+(n/3)*2, y); 
                	
                	divide(n/3, x, y+n/3);
                	divide(n/3, x+n/3, y+n/3); 
                	divide(n/3, x+(n/3)*2, y+n/3); 
                	
                	divide(n/3, x, y+(n/3)*2); 
                	divide(n/3, x+n/3, y+(n/3)*2); 
                	divide(n/3, x+(n/3)*2, y+(n/3)*2); 
                	
                    return;
                }
             }
        } 
		count[arr[y][x]+1]++;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(N, 0, 0);
		
		System.out.println(count[0] + "\n" + count[1] + "\n" + count[2]);
	}
}
