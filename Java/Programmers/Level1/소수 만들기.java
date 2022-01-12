//https://programmers.co.kr/learn/courses/30/lessons/12977

import java.util.*;

class Solution {
    List<List<Integer>> pairs = new ArrayList<>();
    public int solution(int[] nums) {

        boolean [] visited = new boolean[nums.length];
        combination(nums, visited, 0, 0);

        return pairs.size();
    }

    private void combination(int[] nums, boolean[] visited, int start, int k) {

        if(k == 3) {
            addToPair(nums, visited);
        } else {
            for(int i=start; i<nums.length; i++) {
                visited[i] = true;
                combination(nums, visited, i+1, k+1);
                visited[i] = false;
            }
        }
    }

    private void addToPair(int[] nums, boolean[] visited) {
        List<Integer> pair = new LinkedList<>();
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) {
                pair.add(nums[i]);
                sum += nums[i];
            }
        }

        if(isPrime(sum) && pair.size() == 3) {
            pairs.add(pair);
        }
    }

    private boolean isPrime(int sum) {

        for(int i=2; i*i<= sum; i++) {
            if(sum%i == 0) {
                return false;
            }
        }

        return true;
    }
}