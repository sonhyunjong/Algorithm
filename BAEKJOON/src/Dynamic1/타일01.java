package Dynamic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 타일01 {
	
	public static int func(int N) {
		if(N<=1) return 1;
		int[] arr = new int[N+1];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2; i<=N; i++) {	//피보나치 처럼 동작
			arr[i] = (arr[i-1] + arr[i-2]) % 15746; 	//arr[i-1] 수열의 앞에 1 붙인것 + arr[i-2] 수열의 앞에 00을 붙인것
		}
		
		return arr[N];
	}

	public static void main(String[] args) throws IOException {
		//입력 : 첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
		//출력 : 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(func(N)));
		
		bw.flush();
		bw.close();
		br.close();
	}

}
