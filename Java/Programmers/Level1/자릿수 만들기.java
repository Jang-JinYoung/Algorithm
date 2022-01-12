// https://programmers.co.kr/learn/courses/30/lessons/12931

import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        String num = n+"";
        
        
        for(int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            answer = answer + Character.valueOf(c) - 48;    
            
        }

        return answer;
    }
}