// https://www.acmicpc.net/problem/14888

// https://st-lab.tistory.com/118 (참조사이트)

import java.io.*;
import java.util.*;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        // 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
        st = new StringTokenizer(br.readLine());
        int [] op = new int[4];
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(op, arr, arr[0], 1, N);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void backtracking(int[] op, int[] arr, int num, int idx, int N) {

        if(idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for(int i=0; i<op.length; i++) {
            if(op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0: backtracking(op, arr, num+arr[idx], idx+1, N); break;
                    case 1: backtracking(op, arr, num-arr[idx], idx+1, N); break;
                    case 2: backtracking(op, arr, num*arr[idx], idx+1, N); break;
                    case 3: backtracking(op, arr, num/arr[idx], idx+1, N); break;
                }
                op[i]++;
            }

        }
    }


}


