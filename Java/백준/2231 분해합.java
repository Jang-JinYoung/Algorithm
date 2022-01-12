// https://www.acmicpc.net/problem/2231

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=1; i<N; i++) {

            String temp = i + "";
            answer += i;

            for(int j=0; j<temp.length(); j++) {
                int k = Integer.parseInt(temp.charAt(j)+"");
                answer += k;
            }

            if(answer == N) {
                System.out.println(i);
                return;
            } else {
                answer = 0;
            }
        }

        System.out.println(0);

    }


}
