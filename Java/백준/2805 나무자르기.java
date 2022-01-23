// https://www.acmicpc.net/problem/2805

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //나무의 수
        int N = Integer.parseInt(st.nextToken());
        //필요한 나무 M
        int M = Integer.parseInt(st.nextToken());

        long [] arr = new long[N];
        //가장 큰 나무
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if(right < arr[i]) {
                right = arr[i];
            }
        }

        long answer = binarySearch(0, right, arr, M);

        System.out.println(answer);

    }

    public static long binarySearch(long left, long right, long [] woods, int M) {

        long answer = 0;
        while(left <= right) {
            long mid = (left+right)/2;
            long sum = 0;

            for (long wood : woods) {
                if(wood - mid > 0) {
                    sum += (wood - mid); // 만들 수 있는 개수
                }
            }
            
            if(sum < M) { // 만들 수 있는것보다 덜 만들었다면
                //길이를 줄여준다
                right = mid-1;
            } else { // 만들수 있는것보다 더 만들었거나 개수가 같다면 최적의 조건을 찾아준다.
                left = mid+1;
                answer = mid;
            }

        }
        return answer;
    }
}
