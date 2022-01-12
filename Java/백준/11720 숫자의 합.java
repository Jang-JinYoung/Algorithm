// https://www.acmicpc.net/problem/11720

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        String number = br.readLine();

        int answer = 0;
        for(int i=0; i<line; i++) {
            int val = (int) number.charAt(i) - (int) '0';
            answer += val;
        }
        System.out.println(answer);
    }
}
