package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {
	static int[][] confTime;
	
	public static int greedyConf() {
		int result = 0;
		int end_time = 0;
		
		Arrays.sort(confTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
		
        for (int i = 0; i < confTime.length; i++) {
            if (confTime[i][0] >= end_time) {
                end_time = confTime[i][1];
                result++;
            }
        }
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		confTime = new int[N][2];
		
		for(int i=0; i<confTime.length; i++) {
			st = new StringTokenizer(br.readLine());
			confTime[i][0] = Integer.parseInt(st.nextToken());
			confTime[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(greedyConf());
		br.close();
	}
}
