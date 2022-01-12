// https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : scoville) {
            pq.offer(a);
        }

        while(pq.peek() <= K) {
            if(pq.size() == 1) {
                return -1;
            }
            int a = pq.poll();
            int b = pq.poll();

            int result = a + (b*2);
            pq.offer(result);
            answer++;
        }
        
        return answer;
    }
}