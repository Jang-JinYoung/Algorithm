//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[k];

        for(int i=0; i<nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, ((o1, o2) -> map.get(o2).compareTo(map.get(o1))));



        for(int i=0; i<res.length; i++) {
            res[i] = keys.get(i);
        }

        return res;

    }
}