// https://www.acmicpc.net/problem/1300

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // k
        int k = Integer.parseInt(br.readLine());

        //최고의 수
        long left = 0;
        //최악의 수
        long right = (long) N * N;
        long answer = binarySearch(0, right, N, k);
        System.out.println(answer);
    }

    public static long binarySearch(long left, long right, int N, int k) {

        long answer = 0;
        while(left <= right) {
            long mid = (left+right)/2;
            long sum = 0;

            for(int i=1; i<=N; i++) {
                sum += Math.min(N, mid/i);
            }

            if(sum < k) { // 만들 수 있는것보다 덜 만들었다면
                //길이를 늘려준다
                left = mid+1;
            } else { // 만들수 있는것보다 더 만들었거나 개수가 같다면 최적의 조건을 찾아준다.
                right = mid-1;
                answer = mid;
            }

        }
        return answer;
    }
}
