package Dynamic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class 신나는함수실행 {
	static int[][][] dp = new int[21][21][21];
	
	static int w(int a, int b, int c) { 
		boolean range = 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
		
		if(range && dp[a][b][c] != 0) return dp[a][b][c];
		else if(a <= 0 || b <= 0 || c <= 0) return 1;
		else if(a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);
		else if(a < b && b < c) return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	public static void main(String[] args) throws IOException {
		// 입력 : 입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.
		// 출력 : 입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//종료 조건
			if (a == -1 && b == -1 && c == -1) break;
		
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}	
	
}
