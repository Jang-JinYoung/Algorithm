//https://programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

class Solution {

    public static int solution(int[] d, int budget) {

        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for(int i=0; i<d.length; i++) {
            sum = sum + d[i];

            if(sum > budget) {
                answer = i;
                break;
            }
        }

        if(sum <= budget) {
            answer = d.length;
        }

        return answer;
    }
}