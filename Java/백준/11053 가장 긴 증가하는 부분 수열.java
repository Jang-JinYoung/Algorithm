// https://www.acmicpc.net/problem/11053

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 A의 크기
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        int idx = 0;
        int [] memo = new int[N+1];

        for(int i=0; i<N; i++) {
            if(arr[i] > memo[len]) {
                len++;
                memo[len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i], memo);
                memo[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    public static int binarySearch(int left, int right, int key, int [] memo) {
        while(left < right) {
            int mid = (left+right)/2;
            if(memo[mid] < key) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}

