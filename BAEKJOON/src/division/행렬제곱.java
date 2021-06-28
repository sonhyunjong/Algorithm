package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬제곱 {
	static int[][] arr1;
	static int[][] arr2;
	static int[][] result;
	
	public static void func(int N) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sum = 0;
				for(int k = 0; k < N; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				result[i][j] = sum;
			}
		}
		arr1 = result.clone();	
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
	    st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		arr1 = new int[N][N];
		arr2 = new int[N][N];
		result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
				arr2[i][j] = arr1[i][j];
			}
		}
		for(int i=0; i<2; i++) {
			func(N);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
