// https://www.acmicpc.net/problem/1012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int cnt = 0;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] arr = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int m = sc.nextInt();
                int n = sc.nextInt();
                arr[n][m] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] == 1 && !visited[y][x]) {
                        cnt = 0;
                        dfs(arr, y, x, visited);
                        list.add(cnt);
                    }
                }
            }

            answer.append(list.size()).append("\n");
            list.clear();
        }

        System.out.print(answer);
    }

    private static void dfs(int[][] arr, int m, int n, boolean[][] visited) {

        visited[m][n] = true;
        cnt++;

        for(int k=0; k<4; k++) {
            int newY = m + dy[k];
            int newX = n + dx[k];

            if(0 <= newX && newX < arr[0].length && 0 <= newY && newY < arr.length) {
                if(arr[newY][newX] == 1 && !visited[newY][newX]) {
                    dfs(arr, newY, newX, visited);
                }
            }
        }

    }
}
