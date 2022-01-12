// https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            String [] line = sc.next().split("");
            for(int j=0; j<line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean [][] visited = new boolean[N][M];
        int [][] answer = new int[N][M];
        bfs(arr, 0, 0, visited, answer);

        System.out.println(answer[N-1][M-1]+1);
    }

    private static void bfs(int[][] arr, int m, int n, boolean[][] visited, int[][] answer) {
        visited[m][n] = true;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(m, n));

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            for(int k=0; k<4; k++) {
                int newX = x+dx[k];
                int newY = y+dy[k];
                if((0 <= newX && newX < arr[0].length)
                        && (0 <=newY && newY < arr.length)
                        && arr[newY][newX] == 1
                        && !visited[newY][newX] && answer[newY][newX] == 0) {
                    answer[newY][newX] = answer[y][x] + 1;
                    visited[newY][newX] = true;
                    queue.add(new Position(newX, newY));
                }
            }
        }

    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
