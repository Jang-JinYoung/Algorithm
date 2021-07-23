//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        ArrayList<Integer> exceptDupNums = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++) {

            boolean bool = true;
            for(Integer num : exceptDupNums) {
                if(num == nums[i]) {
                    bool = false;
                }
            }

            if(bool) {
                exceptDupNums.add(nums[i]);
            }

        }
        for(int i=0; i<exceptDupNums.size(); i++) {
            nums[i] = exceptDupNums.get(i);
        }
        
        return exceptDupNums.size();

    }
}