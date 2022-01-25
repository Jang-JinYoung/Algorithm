// https://programmers.co.kr/learn/courses/30/lessons/12927

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while(n > 0) { // n을 다 소모할때까지
            if(pq.peek() > 0) { // 0보다 크면
                int work = pq.poll(); // 1개 뺴주고 다시 넣어준다.
                pq.add(work-1);
                n--;
            } else if(pq.peek() == 0) { // 0자체라면 아에 제거해버림
                pq.poll();
            }

            if(pq.isEmpty()) { // 만약 큐가 비어있다면 종료
                break;
            }
        }

        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }


        return answer;
    }
}