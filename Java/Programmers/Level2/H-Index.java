// https://programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        
        //h편의 논문 h회 이상
        //size-h는 h회 이하
       Arrays.sort(citations);

        for(int i=0; i<size; i++) {
            int hindex = size-i;

            if(citations[i] >= hindex) {
                answer = hindex;
                break;
            }
        }

        return answer;
    }
}