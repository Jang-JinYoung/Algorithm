//https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;
import java.util.Collections;


class Solution {
    public String solution(String s) {

        String answer = "";

        String arr[] = s.split("");

        Arrays.sort(arr);

        Collections.reverse(Arrays.asList(arr));

        for(int i=0; i<arr.length; i++)
            answer += arr[i];

        return answer;
    }
}