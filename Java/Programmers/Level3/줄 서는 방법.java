// https://void2017.tistory.com/136 (참조사이트)
// https://programmers.co.kr/learn/courses/30/lessons/12936

import java.util.*;

class Solution {

    static long [] dp;
    public int[] solution(int n, long k) {

        int [] answer = new int[n];
        dp = new long[n+1];
        factorial(n);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        long start = k-1;
        for(int i=1; i<n; i++) {
            int idx = (int) (start / dp[n - i]);
            answer[i-1] = list.get(idx);
            list.remove(idx);
            start %= dp[n - i];
        }

        answer[n-1] = list.get(0);
        return answer;
    }

    private void factorial(int n) {

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = i * dp[i-1];
        }
    }
}

