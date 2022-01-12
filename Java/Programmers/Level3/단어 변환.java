// https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<Integer> answer = new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words).subList(0, words.length));

        if(!list.contains(target)) {
            return 0;
        }

        boolean [] visited = new boolean[list.size()];

        int count = 0;
        for(int i=0; i<list.size(); i++) {
            dfs(list, visited, begin, target, count);
        }

        return Collections.min(answer);
    }

    private void dfs(List<String> list, boolean[] visited, String word, String target, int count) {

        if(word.equals(target)) {
            answer.add(count);
            return;
        }

        for(int i = 0; i<list.size(); i++) {
            if(!visited[i]) {
                String comparedWord = list.get(i);
                boolean bool = true;
                int diff = 0;

                for(int j=0; j<comparedWord.length(); j++) {
                    if(word.charAt(j) != comparedWord.charAt(j)) {
                        diff++;
                    }
                    if(diff > 1) {
                        bool = false;
                        break;
                    }
                } // 단어비교 for
                if(bool) {
                    visited[i] = true;
                    dfs(list, visited, comparedWord, target, count+1);
                    visited[i] = false;
                }
            }
        }

    }
}