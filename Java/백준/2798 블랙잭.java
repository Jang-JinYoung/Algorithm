// https://www.acmicpc.net/problem/2798

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> blackjack = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String [] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] cards = new int[st.countTokens()];

        for(int i=0; i<cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
        boolean [] visited = new boolean[cards.length];

        combination(cards, visited, 0, M, 0);

        System.out.println(Collections.max(blackjack));

    }

    private static void combination(int[] cards, boolean[] visited, int start, int m, int size) {

        if(size == 3) {
            addPair(cards, visited, m);
        } else {
            for(int i=start; i<cards.length; i++) {
                visited[i] = true;
                combination(cards, visited, i+1, m, size+1);
                visited[i] = false;
            }
        }
    }

    private static void addPair(int[] cards, boolean[] visited, int m) {

        List<Integer> list = new ArrayList<>();

        int sum = 0;
        for(int i=0; i<cards.length; i++) {
            if(visited[i]) {
                sum += cards[i];
                list.add(cards[i]);
            }
        }

        if(sum <= m && list.size() == 3) {
            blackjack.add(sum);
        }
    }

}
