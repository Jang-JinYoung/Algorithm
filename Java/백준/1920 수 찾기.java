// https://www.acmicpc.net/problem/1920

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //sorting
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int [] search = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            search[i] = Integer.parseInt(st.nextToken());
            System.out.println(searchBinary(0, N, search[i], arr));

        }
    }

    private static int searchBinary(int left, int right, int key, int[] arr) {

        while(left < right) {
            int mid = (left+right)/2;
            if(arr[mid] < key) {//찾는값이 더 클때
                left = mid+1;
            } else if(arr[mid] > key){//찾는값이 더 작을때
                right = mid;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
