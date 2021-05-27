package sort;

import java.util.Arrays;

class Solution2 {
    public int solution2(int[] citations) {
       int answer = 0;
       Arrays.sort(citations);
        
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i]>answer)answer++;
            else break;
        }
        return answer;
    }
}
public class H인덱스 {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		Solution2 s = new Solution2();
		System.out.println(s.solution2(citations));
	}

}
