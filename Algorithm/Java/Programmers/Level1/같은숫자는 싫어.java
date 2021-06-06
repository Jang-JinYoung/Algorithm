//https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n, count=0;

        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            n = arr[i];
            if(list.get(count) != n) {
                list.add(arr[i]);
                count++;
            }
        }

        int answer[] = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}