// https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public int solution(int[][] maps) {

        int m = maps.length;
        int n = maps[0].length;

        int [][] check = new int[m][n];
        boolean [][] visited = new boolean[m][n];

        bfs(maps, check, visited);
        
        return check[m-1][n-1] == 0 ? -1 : check[m-1][n-1];
    }

    private void bfs(int[][] maps, int[][] check, boolean[][] visited) {

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visited[0][0] = true;
        check[0][0] = 1;

        while(!queue.isEmpty()) {

            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            for(int k=0; k<4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if((0 <= newX && newX < maps[0].length)
                    && (0 <= newY && newY < maps.length)
                    && (!visited[newY][newX])
                    && maps[newY][newX] == 1) {

                    visited[newY][newX] = true;
                    check[newY][newX] = check[y][x]+1;
                    queue.add(new Position(newX, newY));
                }

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