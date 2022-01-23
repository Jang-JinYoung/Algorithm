// https://www.acmicpc.net/problem/11047

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전 개수
        int N = Integer.parseInt(st.nextToken());
        
        // 금액
        int K = Integer.parseInt(st.nextToken());

        // 동전 입력
        int [] coin = new int[N];
        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int answer =0;

        for(int i=N-1; i>=0; i--) {
            if(K >= coin[i]) {
                answer += K/coin[i];
                K = K%coin[i];
            }
        }
        System.out.println(answer);
    }
}
