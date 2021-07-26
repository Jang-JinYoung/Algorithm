//https://leetcode.com/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int max = 0;
        int idx = 1;

        max = nums[nums.length-1];
        for(int i=nums.length-1; i>=0; i--) {
            if(max != nums[i]) {
                max = nums[i];
                idx++;
            }

            if(idx == 3) {
                return max;
            }
        }


        return nums[nums.length-1];
    }
}