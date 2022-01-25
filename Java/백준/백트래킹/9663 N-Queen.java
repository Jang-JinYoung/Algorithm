// https://st-lab.tistory.com/118 (참조사이트)
// https://www.acmicpc.net/problem/9663

import java.io.*;
import java.util.*;

public class Main {
    static int [] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1부터 N까지
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        backtracking(N, 0);
        System.out.println(answer);

    }

    private static void backtracking(int N, int depth) {
        if(depth == N) {
//            System.out.println("정답 !" + Arrays.toString(arr));
            answer++;
            return;
        }
        for(int i=0; i<N; i++) {
            arr[depth] = i;
            if(possibility(depth)) {
                backtracking(N, depth+1);
            }
        }
    }

    public static boolean possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}


