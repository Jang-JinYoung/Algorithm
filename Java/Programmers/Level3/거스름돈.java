https://programmers.co.kr/learn/courses/30/lessons/12907

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        long [] dp = new long[n+1];

        dp[0] = 1;
        for(int i=0; i<money.length; i++) {
            int p = money[i];
            for(int j=p; j<=n; j++) {
                dp[j] += dp[j-p];
            }
        }

        return (int) dp[n]%1000000007;
    }
}