// https://www.acmicpc.net/problem/1654

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //랜선의 개수
        int K = Integer.parseInt(st.nextToken());
        //필요한 랜선의 개수
        int N = Integer.parseInt(st.nextToken());

        int [] arr = new int[K];
        int total = 0;

        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        int answer = binarySearch(0, total/N, arr, N);

        System.out.println(answer);

    }

    public static int binarySearch(int left, int right, int [] arr, int N) {

        int answer = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                sum += (arr[i]/mid); // 만들 수 있는 개수
            }

            if(sum < N) { // 만들 수 있는것보다 덜 만들었다면
                //길이를 줄여준다
                right = mid+1;
            } else { // 만들수 있는것보다 더 만들었거나 개수가 같다면 최적의 조건을 찾아준다.
                left = mid+1;
                answer = mid;
            }

        }
        return answer;
    }
}
