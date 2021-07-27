// https://leetcode.com/problems/combination-sum-iii/

class Solution {
    static List<List<Integer>> pairs = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        //k = 개수 n = 총 합
        pairs.clear();
        boolean visited[] = new boolean[10];
        combination(k, n, visited, 1, 0);


        return pairs;
    }

    private void combination(int k, int n, boolean visited[], int start, int sum) {

        if(sum == n) {
            addPairs(visited, k);
        } else {
            for(int i=start; i<10; i++) {
                visited[i] = true;
                combination(k, n, visited, i+1, sum+i);
                visited[i] = false;
            }
        }
    }

    private void addPairs(boolean[] visited, int k) {

        List<Integer> pair = new ArrayList<>();

        for(int i=0; i<visited.length; i++) {
            if(visited[i]) {
                pair.add(i);
            }
        }

        if(pair.size() == k) {
            pairs.add(pair);
        }
    }
}