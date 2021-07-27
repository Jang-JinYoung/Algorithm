//https://leetcode.com/problems/3sum/


class Solution {

    static List<List<Integer>> valuePairs = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
         valuePairs.clear();

        boolean visited[] = new boolean[nums.length];
        int n = nums.length;
        combination(nums, visited, 0, n, 3);

        return valuePairs.stream().distinct().collect(Collectors.toList());
    }


    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            addToPairs(arr, visited, n);
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(arr, visited, i+1, n, r-1);
                visited[i] = false;
            }
        }
    }

    static void addToPairs(int arr[], boolean visited[], int n) {
        List<Integer> valuePair = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                valuePair.add(arr[i]);
                sum = sum + arr[i];
            }
        }

        Collections.sort(valuePair);

        if(sum == 0)
            valuePairs.add(valuePair);
    }


}