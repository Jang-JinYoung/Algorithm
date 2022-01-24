// https://programmers.co.kr/learn/courses/30/lessons/12938

import java.util.Arrays;

class Solution {
    // 집합의 원소의 개수 n과 모든 원소들의 합 s
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s){
            return new int[]{-1};
        } else {
            answer = new int[n];

            int q = s/n; // 4
            int r = s%n; // 0
            Arrays.fill(answer, q);

            for(int i=0; i<r; i++) {
                answer[answer.length - 1 - i]++;
            }
        }

        return answer;
    }
}