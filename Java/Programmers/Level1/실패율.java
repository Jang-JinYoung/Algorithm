//https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        //실패율
        float failure[] = new float[N];

        //도전자
        int n = stages.length;

        //각 스테이지에 대한 도전자의 수 배열
        int challenger[] = new int[N];

        //각 스테이지에 대한 도전자의 수
        for(int i=0; i<stages.length; i++) {

            //단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
            if(stages[i] < N+1)
                challenger[stages[i]-1]++;

        }

        for(int i=0; i<failure.length; i++) {
            failure[i] = challenger[i]/(float)n;
            n = n - challenger[i];
        }

        for(int i=0; i<failure.length; i++) {
            float max = failure[i];
            int idx = i;

            for(int j=0; j<failure.length; j++) {

                if(max <= failure[j]) {

                    //만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
                    if(max == failure[j]) {
                        if(idx > j) {
                            max = failure[j];
                            idx = j;
                        }
                    } else {
                        max = failure[j];
                        idx = j;
                    }
                }

            }//2중 for

            failure[idx] = -1;
            answer[i] = idx+1;

        }
        return answer;
    }
}