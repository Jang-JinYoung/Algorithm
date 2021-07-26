//https://leetcode.com/problems/climbing-stairs/


class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {


        for(int i=1; i<=n; i++) {
            if(i == 1 || i == 2) {
                memo.put(i, i);
            } else {
                memo.put(i, memo.get(i-2)+memo.get(i-1));
            }
        }

        return memo.get(n);
    }

}
