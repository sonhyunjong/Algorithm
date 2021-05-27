package BAEKJOON.Bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Decomposition {

	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strNum = br.readLine();
		int result = 0; 
		int intNum = Integer.parseInt(strNum);
		
		//N(3) = K + k1 + k2 + k3 
		//N(3) - (k1 + k2 + k3) = K
		//N(3) - k*9 = K  (자릿수의 최대 값 9)
		for(int i = (intNum - (strNum.length() * 9)); i < intNum; i++) {
			int number = i;
			int sum = 0;	
			
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			if(sum + i == intNum) {
				result = i;
				break;
			}
		}
		
		//출력
		bw.write(String.valueOf(result));
		br.close();
		bw.flush();
		bw.close();
	}

}
