import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<Integer>();
        
        for(int j=0; j<commands.length; j++){
            for(int i=commands[j][0]-1; i<commands[j][1]; i++){
                list.add(array[i]);
            }
            Collections.sort(list);	//리스트로 소트
            answer[j] = list.get(commands[j][2]-1);
<<<<<<< HEAD
<<<<<<< HEAD
            list.clear();	//리스트 비우기 
=======
            list.clear();
>>>>>>> parent of 5b70470 (//)
=======
            list.clear();	//리스트 비우기 
>>>>>>> 80bb876215430e5719e91601666261b6888dba0a
        }
        return answer;
    }
}

public class K번째수 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new int[commands.length];
		
		Solution s = new Solution();
		answer = s.solution(array, commands);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
