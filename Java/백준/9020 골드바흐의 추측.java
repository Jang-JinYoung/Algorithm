// https://www.acmicpc.net/problem/9020

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] prime = new int[10001];
        Arrays.fill(prime, 0);

        for(int i=2; i<prime.length; i++) {
            boolean bool = true;
            for(int j=2; j*j<=i; j++) {
                if(i%j == 0) {
                    bool = false;
                    break;
                }
            }

            if(bool) {
                prime[i] = 1;
            }
        }


        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());

            int size = input/2;

            for(int j=0; j<size; j++) {
                int num1 = size - j;
                int num2 = input - num1;

                if(prime[num1] == 1 && prime[num2] == 1) {
                    answer.append(num1).append(" ").append(num2).append("\n");
                    break;
                }
            }
        }

        System.out.print(answer.toString());
    }
}
