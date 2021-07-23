//https://programmers.co.kr/learn/courses/30/lessons/42862

class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {

        int answer = n-lost.length;

        for(int i=0; i<lost.length; i++) {
            if(isDupCheck(lost[i], reserve)) {//중복이면
                lost[i] = -1;
                answer++;
            }
        }

        for(int i=0; i<lost.length; i++) {

            if((isCheck(lost[i], reserve))) {//빌려줄 수 없는 상황이라면
                answer++;
            }
        }

        return answer;

    }

    //idx = 학생번호
    private static boolean isDupCheck(int idx, int[] reserve) {

        for(int i=0; i<reserve.length; i++) {
            if(idx == reserve[i]) {
                reserve[i] = -1;
                return true;
            }
        }
        return false;
    }

    private static boolean isCheck(int idx, int[] reserve) {

        for(int i=0; i<reserve.length; i++) {//만약 i-1값이 존재한다면

            if(idx == reserve[i]-1) {
                reserve[i] = -1;
                return true;
            }
            if(idx == reserve[i]+1) {//만약 i+1값이 존재한다면
                reserve[i] = -1;
                return true;
            }

        }

        return false;
    }
}