// https://programmers.co.kr/learn/courses/30/lessons/64064

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        for(int i=0; i<banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        boolean [] visited = new boolean[user_id.length];
        dfs(visited, user_id, banned_id, 0, "");

        return set.size();
    }

    private void dfs(boolean[] visited, String[] user_id, String[] banned_id, int r, String result) {

        if(r == banned_id.length) {
            String [] arr = result.split(" ");
            Arrays.sort(arr);
            StringBuilder answer = new StringBuilder();
            for(int i=0; i<arr.length; i++) {
                answer.append(arr[i]);
            }

            set.add(answer.toString());
            return;
        }

        for(int i=0; i<user_id.length; i++) {
            if(!visited[i] && user_id[i].matches(banned_id[r])) {
                visited[i] = true;
                dfs(visited, user_id, banned_id, r+1, result + " " + user_id[i]);
                visited[i] = false;
            }
        }
    }
}