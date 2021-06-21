package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
	static int[][] arr;
	static int[] count = new int[2];
	
	static void divide(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != arr[y][x]) {
                    divide(n / 2, y, x);
                    divide(n / 2, y + n / 2, x);
                    divide(n / 2, y, x + n / 2);
                    divide(n / 2, y + n / 2, x + n / 2);

                    return;
                }
        }

        count[arr[y][x]]++;
    }
}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//입력
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//출력
		for(int i=0; i<2; i++) {
			System.out.println(count[i]);
		}
		br.close();
	}

}
