// https://programmers.co.kr/learn/courses/30/lessons/42627

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; // 수행된 요청 갯수
        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스

        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        for(int i=0; i<jobs.length; i++) {
            for(int j=0; j<jobs[i].length; j++) {
                System.out.print(jobs[i][j]);
            }
            System.out.println();
        }

        // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(count < jobs.length) {

            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }

            if(pq.isEmpty()) {//우선순위 큐가 비어있으면
                end = jobs[jobsIdx][0];
            } else {//우선순위 큐가 비어있지 않으면
                int [] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }


        }

        return (int) Math.floor(answer / jobs.length);
    }
}