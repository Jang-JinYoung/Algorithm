//https://programmers.co.kr/learn/courses/30/lessons/68935

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(n!=0) {
            int k = n%3;
            n = n/3;
            sb.append(k);
        }

        int k=1;
        for(int i=sb.length()-1; i>=0; i--) {
            answer = answer + (Character.valueOf(sb.charAt(i)) - '0') * k;
            k = k*3;
        }

        return answer;
    }
}