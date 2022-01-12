// https://www.acmicpc.net/problem/2667

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];

        for(int i=0; i<size; i++) {
            String [] line = br.readLine().split("");
            for(int j=0; j<size; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        List<Integer> answer = new LinkedList<>();
        boolean [][] visited = new boolean[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(arr, i, j, visited);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static void dfs(int[][] arr, int m, int n, boolean[][] visited) {

        visited[m][n] = true;
        cnt++;

        for(int k=0; k<4; k++) {
            int newY = m + dy[k];
            int newX = n + dx[k];

            if(0 <= newX && newX < arr.length && 0 <= newY && newY < arr.length) {
                if(arr[newY][newX] == 1 && !visited[newY][newX]) {
                    dfs(arr, newY, newX, visited);
                }
            }
        }

    }
}
