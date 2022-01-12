// https://www.acmicpc.net/problem/1697

import java.io.IOException;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[100001];
    static int answer;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        visited[N] = true;

        bfs(N, K);
        System.out.println(answer);
    }

    private static void bfs(int n, int k) {
        
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(n, 0));

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            if(x == k) {
                answer = y;
                break;
            }

            if(valid(x-1)) {
                visited[x-1] = true;
                queue.add(new Position(x-1, y+1));
            }
            if(valid(x+1)) {
                visited[x+1] = true;
                queue.add(new Position(x+1, y+1));
            }
            if(valid(x*2)) {
                visited[x*2] = true;
                queue.add(new Position(x*2, y+1));
            }
        }
    }

    public static boolean valid(int n) {
        return n >= 0 && n <= 100000 && !visited[n];
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
