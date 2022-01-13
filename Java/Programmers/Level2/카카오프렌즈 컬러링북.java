// https://programmers.co.kr/learn/courses/30/lessons/1829

import java.util.*;

class Solution {

    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static int cnt = 0;
    List<Integer> list = new ArrayList<>();

    public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];


        boolean [][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    cnt = 0;
                    bfs(visited, picture, i, j);
                    list.add(cnt);
                }
            }
        }

        answer[0] = list.size();
        answer[1] = Collections.max(list);


        return answer;
    }

    private void bfs(boolean[][] visited, int [][] picture, int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        visited[y][x] = true;
        int color = picture[y][x];
        queue.add(new Position(x, y));
        cnt++;

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            x = pos.x;
            y = pos.y;

            for(int k=0; k<4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if((0 <= newY && newY < picture.length)
                    && (0 <= newX && newX < picture[0].length)
                    && !visited[newY][newX]
                    && picture[newY][newX] == color) {

                    visited[newY][newX] = true;
                    queue.add(new Position(newX, newY));
                    cnt++;

                } // if
            } // for
        } // while

    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}