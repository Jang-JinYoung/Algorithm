//https://leetcode.com/problems/two-sum/

class Solution {
    public static int[] twoSum(int[] nums, int target) {
    	
    	int answer[] = new int[2];
    	
    	for(int i=0; i<nums.length; i++) {
    		for(int j=i+1; j<nums.length; j++) {
    			if(nums[i] + nums[j] == target) {
    				answer[0] = i;
    				answer[1] = j;
    				break;
    			}
    		}
    	}
    	
    	System.out.println(answer[0] + "," + answer[1]);
    	
    	return answer;
    	
    }
}
