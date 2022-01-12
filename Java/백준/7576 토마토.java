// https://www.acmicpc.net/problem/7576

import java.io.IOException;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Position> tomato = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        //토마토 상자 세팅
        int[][] arr = new int[N][M];
        int[][] answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                answer[i][j] = arr[i][j];

                if (arr[i][j] == 1) {//토마토위치만 추가
                    tomato.add(new Position(j, i, 1));
                }
            }
        }

        boolean[][] visited = new boolean[N][M];


        bfs(arr, visited, answer);
//
//        System.out.println("\n=====");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

        //정답판별
        boolean bool = false;
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                if(max < answer[i][j]) {
                    max = answer[i][j];
                }
                if(answer[i][j] == 0) {
                    bool = true;
                    break;
                }
            }
            if(bool) {
                break;
            }
        }

        if(bool) {
            System.out.println(-1);
        } else {
            System.out.println(max-1);
        }

    }

    private static void bfs(int[][] arr, boolean[][] visited, int[][] answer) {

        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < tomato.size(); i++) {
            int x = tomato.get(i).x;
            int y = tomato.get(i).y;
            queue.add(new Position(x, y, 1));
        }

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            int day = pos.day;

            visited[y][x] = true;
            answer[y][x] = day;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if ((0 <= newX && newX < arr[0].length)
                        && (0 <= newY && newY < arr.length)
                        && (!visited[newY][newX])
                        && (arr[newY][newX] == 0)) {

                    answer[newY][newX] = day;
                    visited[newY][newX] = true;
                    queue.add(new Position(newX, newY, day+1));
                }

            }
        }
    }
}

class Position {
    int x;
    int y;
    int day;

    Position(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

