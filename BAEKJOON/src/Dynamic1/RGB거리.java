package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
	static int[][] DP;
	static int[][] RGB;
	
	public static int rgbCost(int T, int color) {
		if(DP[T][color]==0) {
			if(color == 0) {
				DP[T][color] = Math.min(rgbCost(T - 1, 1), rgbCost(T - 1, 2)) + RGB[T][0];
			}
			else if(color == 1) {
				DP[T][color] = Math.min(rgbCost(T - 1, 0), rgbCost(T - 1, 2)) + RGB[T][1];
			}
			else {
				DP[T][color] = Math.min(rgbCost(T - 1, 0), rgbCost(T - 1, 1)) + RGB[T][2];
			}
		}
		return DP[T][color];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		DP = new int[T][3];
		RGB = new int[T][3];
		
		for( int i = 0 ; i < T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				RGB[i][0] = Integer.parseInt(st.nextToken());
				RGB[i][1] = Integer.parseInt(st.nextToken());
				RGB[i][2] = Integer.parseInt(st.nextToken());
				
		}
		DP[0][0] = RGB[0][0];
		DP[0][1] = RGB[0][1];
		DP[0][2] = RGB[0][2];
		
		System.out.println(Math.min(rgbCost(T- 1, 0), Math.min(rgbCost(T - 1, 1), rgbCost(T - 1, 2))));
		
		br.close();
	}

}
