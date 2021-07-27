//https://leetcode.com/problems/combination-sum-ii/

class Solution {

    static  List<List<Integer>> pairs = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        boolean visited[] = new boolean[candidates.length];
        pairs.clear();

        int sum = 0;
        for(int i=0; i<candidates.length; i++) {
            sum += candidates[i];
        }

        if(sum < target) {
            return pairs;
        }

        if(sum == target) {
            List<Integer> pair = Arrays.stream(candidates).boxed().collect(Collectors.toList());
            pairs.add(pair);

            return pairs;
        }

        combination(candidates, visited, 0, 0, target);

        //중복값 제거 return
        return pairs.stream().distinct().collect(Collectors.toList());

    }

    private void combination(int[] candidates, boolean[] visited, int start, int sum, int target) {

        if(sum == target) {
            addPairs(candidates, visited);
        } else if(sum < target) {
            for(int i=start; i<candidates.length; i++) {
                //다음값이 동일값이면 제끼고 진행함
                if(i > start && candidates[i] == candidates[i-1]) continue;
                visited[i] = true;
                combination(candidates, visited, i+1, sum+candidates[i], target);
                visited[i] = false;
            }
        }

    }

    private void addPairs(int[] candidates, boolean[] visited) {

        List<Integer> pair = new ArrayList<>();

        for(int i=0; i<candidates.length; i++) {
            if(visited[i]) {
                pair.add(candidates[i]);
            }
        }

        //stream().distinct() 를 쓰기위해 정렬
        Collections.sort(pair);
        pairs.add(pair);
    }
}