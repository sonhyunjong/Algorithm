import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution1 {
    public String solution1(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numbers.length; i++) {
        	list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int index = 0;
				for(int i=0; i<3; i++) {
					if(o1.charAt(i) == o2.charAt(i)) {
						if(o1.length()!=o2.length()) {
							return Integer.parseInt(o1.concat(o2))-Integer.parseInt(o2.concat(o1));
						}else {
							continue;
						}
					}else {
						index = i;
						break;
					}
				}
				return o1.charAt(index)-o2.charAt(index);
			}
		});
  
        for(int i=list.size()-1; i>-1; i--) {
        	sb.append(list.get(i));
        }
        answer = sb.toString();
        return answer;
    }
}
public class 가장큰수 {

	public static void main(String[] args) {
		//int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
		
		Solution1 s = new Solution1();
		System.out.println(s.solution1(numbers));
	}

}
