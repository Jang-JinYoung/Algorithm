// https://www.acmicpc.net/problem/3273

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

        //셋째 줄에는 x가 주어진다.
        int x = Integer.parseInt(br.readLine());

        // 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수
        Arrays.sort(arr); // ai + aj = x (1 ≤ i < j ≤ n)을 만족
        int ans = 0;
        int left = 0, right = arr.length-1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum == x) ans++;

            if(sum <= x) left++;
            else right--;
        }

        System.out.println(ans);

    }
}


