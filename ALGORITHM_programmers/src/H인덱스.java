import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public int solution2(int[] citations) {

        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<citations.length; i++) {
        	list.add(citations[i]);
        }
        Collections.sort(list);
        
        return list.get(list.size()/2);
    }
}
public class H인덱스 {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		Solution2 s = new Solution2();
		System.out.println(s.solution2(citations));
	}

}
