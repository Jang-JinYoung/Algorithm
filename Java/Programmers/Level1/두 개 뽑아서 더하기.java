//https://programmers.co.kr/learn/courses/30/lessons/68644

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(!array.contains(numbers[i]+numbers[j])) {
                    array.add(numbers[i]+numbers[j]);
                }
            }
        }

        int answer[] = new int[array.size()];

        for(int i=0; i<array.size(); i++) {
            answer[i] = array.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}