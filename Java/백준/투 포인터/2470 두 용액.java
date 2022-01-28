// https://www.acmicpc.net/problem/2470

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 수열의 크기 n이 주어진다.
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        // 수열에 포함되는 수가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        int min=0, max=0, fix = Integer.MAX_VALUE;
        while(left < right) {
            int diff = arr[left] + arr[right];

            if(Math.abs(diff) < fix) {
                fix = Math.abs(diff);
                min = arr[left];
                max = arr[right];
            }

            if(diff < 0) left++;
            else right--;
        }

        System.out.println(min + " " + max);

    }
}


