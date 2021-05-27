package BAEKJOON.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 : 85792KB, 시간 : 312ms
public class FilmDirectorSean {

	public static void main(String[] args) throws Exception, IOException {
		// 입력 : 첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
		// 출력 : 첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		//666이 들어간 숫자 중 최솟값(N<=10000)
		
		int start = 666;
		int count = 0;
		
		while(count!=num) {
			String str= String.valueOf(start);
			
			if(str.contains("666")) {
				count++;
			}
			
			start++;
		}
		
		System.out.println(start-1);
	}
}
