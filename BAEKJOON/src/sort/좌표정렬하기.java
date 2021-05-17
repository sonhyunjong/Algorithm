package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표정렬하기 {

	public static void main(String[] args) throws IOException {
		// 입력 : 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
		// 출렵 : 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		int[][] xy = new int[count][2];
		
		for(int i=0; i<count; i++) {
			String[] s = br.readLine().split(" ");
			xy[i][0]= Integer.parseInt(s[0]);
			xy[i][1]= Integer.parseInt(s[1]);
		}
		
		//sort
		Arrays.sort(xy, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
				
			}
			
		});
		
		//출력
		for(int i=0; i<count; i++) {
			bw.write(xy[i][0]+" "+xy[i][1]+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
