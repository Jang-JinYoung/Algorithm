// https://programmers.co.kr/learn/courses/30/lessons/12934

class Solution {
    public long solution(long n) {
        long answer = -1;

        for(long i = 0; i*i<=n; i++) {
            if(i*i == n) {
                answer = (long) Math.pow(i+1, 2);
                break;
            }
        }
        return answer;
    }
}