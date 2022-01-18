// https://programmers.co.kr/learn/courses/30/lessons/42895

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        int answer = 1;
        Set<Integer> list[] = new Set[9]; //숫자모음

        for(int i = 0 ; i < 9 ; i++) {
            list[i] = new HashSet<>();
        }

        StringBuilder num = new StringBuilder();

        if (N == number) {
            return 1;
        }


        for (int i = 1; i < 9; i++) {
            num.append(N);
            int NN = Integer.parseInt(num.toString());
            list[i].add(NN);

            for (int j = 1; j < i; j++) {
                for(int p : list[j]) {
                    for(int k : list[i-j]) {
                        list[i].add(p+k);
                        list[i].add(p-k);
                        list[i].add(p*k);
                        if(k != 0)
                            list[i].add(p/k);
                    }
                }
            }
            if(list[i].contains(number)) {
                return i;
            }
        }


        return -1;
    }
}
