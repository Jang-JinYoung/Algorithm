// https://github.com/encrypted-def/kakao-blind-recruitment/blob/master/2022-blind/Q4_1.java (cmp 메서드 로직 참고)
// https://programmers.co.kr/learn/courses/30/lessons/92342

import java.util.Arrays;

class Solution {

    int [] answer;
    static int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {

        int [] scores = new int[info.length];
        answer = new int[info.length];
        Arrays.fill(answer, -1);
        dfs(info, scores, n, 0);

        if(answer[0] == -1) { // 라이언이 우승할 수 없는 경우(무조건 지거나 비기는 경우)
            return new int[]{-1};
        } else {
            return answer;
        }
    }

    private void dfs(int[] info, int[] scores, int n, int depth) {
        if(depth == 10) {
            scores[depth] = n;
            getScores(info, scores);
            return;
        }
        for(int i=0; i<=n; i++) {
            scores[depth] = i; // 화살
            dfs(info, scores, n-i, depth+1); //쏜 화살만큼 제거해준다.
        }

    }

    private void getScores(int [] info, int [] scores) {

        int crew1 = 0; // 라이언
        int crew2 = 0; // 어피치

        for(int i=0; i<scores.length; i++) {
            if (scores[i] > info[i]) {
                crew1 += (10 - i);
            } else if(info[i] != 0) { // a = b일 경우는 어피치가 k점을 가져갑니다.
                crew2 += (10 - i);
            }
        }

        if(crew1 > crew2) {
            if(crew1-crew2 > max) {
                System.arraycopy(scores, 0, answer, 0, 11);
                max = crew1-crew2;
            } else if(crew1 - crew2 == max){
                if(cmp(scores, answer)) {
                    System.arraycopy(scores, 0, answer, 0, 11);
                }
            }
        }
    }

    public boolean cmp(int[] a, int[] b){
        for(int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return false;
    }
}
