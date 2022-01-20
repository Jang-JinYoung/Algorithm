// https://www.acmicpc.net/problem/10816

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int [] search = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            search[i] = Integer.parseInt(st.nextToken());
            int lower = lowerBound(0, N, search[i], arr);
            int upper = upperBound(0, N, search[i], arr);
            bw.append(upper-lower + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    // lower_bound는 찾으려 하는 key 값이 "없으면" key 값보다 큰 가장 작은 정수 값을 찾습니다.
    private static int lowerBound(int left, int right, int key, int[] arr) {

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key) {//찾는값이 더 클때
                left = mid + 1;
            } else {//찾는값이 더 작을때
                right = mid;
            }
        }
        return right+1;
    }

    // upper_bound는 key값을 초과하는 가장 첫 번째 원소의 위치를 구하는 것 입니다.
    private static int upperBound(int left, int right, int key, int[] arr) {

        while(left < right) {
            int mid = (left+right)/2;
            if(arr[mid] <= key) {//찾는값이 더 클때
                left = mid+1;
            } else {//찾는값이 더 작을때
                right = mid;
            }
        }

        return right+1;
    }
}

/*

System.out.println() 으로 작성했더니 시간 초과가 났다.
BufferedReader 종종 사용하자.

 */