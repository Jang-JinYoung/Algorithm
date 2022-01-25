// https://www.acmicpc.net/problem/15650

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [] visited = new boolean[N];
        int [] arr = new int[M];

        backtracking(visited, arr, M, 0);
    }

    private static void backtracking(boolean[] visited, int[] arr, int m, int depth) {
        if(depth == m) {
            check(arr);
        } else {
            for(int i=0; i<visited.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i+1;
                    backtracking(visited, arr, m, depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    private static void check(int []arr) {

        StringBuilder sb = new StringBuilder();
        boolean bool = true;
        for(int i=0; i<arr.length-1; i++) {
            sb.append(arr[i]).append(" ");
            if(arr[i] > arr[i+1]) {
                bool = false;
                break;
            }
        }

        if(bool) {
            sb.append(arr[arr.length-1]);
            System.out.println(sb.toString());
        }
    }
}


