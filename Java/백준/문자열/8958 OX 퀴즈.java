// https://www.acmicpc.net/problem/8958

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            int score = 1;
            int sum = 0;

            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);

                if(c == 'X') {
                    score = 1;
                } else {
                    sum += score;
                    score++;
                }
            }
            System.out.println(sum);
        }



    }
}


