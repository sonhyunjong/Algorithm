package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈 {
	
	public static long divide(long a, long b, long c) {
		long result = 0;
		
		if (b == 0) {
            result = 1;
        } else if (b == 1) {
            result = a;
        } else if (b % 2 == 0) {
            long n = divide(a, b / 2, c) % c;
            result = (n * n) % c;
        } else { 
            long n = divide(a, b / 2, c) % c;
            result = (((n * n) % c) * a) % c;
        }
		return result%c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(divide(A, B, C));
	}
}
