// https://programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    static int answer = 0;
    public int solution(int[] nums, int target) {
        boolean [] visited = new boolean[nums.length];
        int start = 0;

        recursive(nums, start, target, visited);

        return answer;
    }

    private void recursive(int[] nums, int start, int target, boolean[] visited) {

        for(int i=start; i<nums.length; i++) {
            visited[i] = true;
            recursive(nums, i+1, target, visited);
            visited[i] = false;
        }

        int total = 0;
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) {
                total += nums[i];
            } else {
                total += nums[i] * -1;
            }
        }

        if(total == target) {
            answer++;
        }

    }
}