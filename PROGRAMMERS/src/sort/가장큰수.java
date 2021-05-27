package sort;

import java.util.Arrays;

class Solution1 {
    public String solution1(int[] numbers) {
        String answer="";
        String[] result = new String[numbers.length];
        for(int i =0; i<numbers.length; i++){
            result[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(result, (o1,o2)->(o2+o1).compareTo(o1+o2));
        if(result[0].equals("0"))return "0";
   
        for(String a : result){
            answer +=a;
        }
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