// https://programmers.co.kr/learn/courses/30/lessons/12954

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long k = x;

        for(int i=0; i<n; i++) {
            answer[i] = k;
            k = k+x;

        }
        return answer;
    }
}