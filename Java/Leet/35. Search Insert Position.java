// https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {


        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target)
                return i;
        }

        int[] temp = new int[nums.length+1];

        for(int i=0; i<nums.length; i++) {
            temp[i] = nums[i];
        }
        temp[temp.length-1] = target;

        Arrays.sort(temp);

        for(int i=0; i<temp.length; i++) {
            if(temp[i] == target)
                return i;
        }

        return 0;
    }
}