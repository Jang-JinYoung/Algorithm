// https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {

            String [] temp = operation.split(" ");
            String op = temp[0];
            int num = Integer.parseInt(temp[1]);

            if(op.equals("I")) {
                max_pq.offer(num);
                min_pq.offer(num);
            } else {
                if(num == 1) { // 최대값 삭제
                    min_pq.remove(max_pq.poll());
                } else { // 최소값 삭제
                    max_pq.remove(min_pq.poll());
                }
            }
        }

        if(!max_pq.isEmpty() && !min_pq.isEmpty()) {
            answer[0] = max_pq.poll();
            answer[1] = min_pq.poll();
        }

        return answer;
    }
}