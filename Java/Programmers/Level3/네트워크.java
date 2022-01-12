// https://programmers.co.kr/learn/courses/30/lessons/43162

class Solution {
    public int solution(int n, int[][] computers) {

        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(visited, computers, n, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(boolean[] visited, int[][] computers, int n, int i) {

        visited[i] = true;
        for(int j=0; j<n; j++) {
            if(computers[i][j] == 1 && !visited[j] && i != j) {
                dfs(visited, computers, n, j);
            }
        }
    }

}