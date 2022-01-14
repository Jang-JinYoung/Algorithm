// https://programmers.co.kr/learn/courses/30/lessons/12981


import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        HashMap<String, Boolean> hashMap = new HashMap<>();

        String beforeWord = words[0];
        hashMap.put(beforeWord, true);
        for(int i=1; i<words.length; i++) {
            String nowWord = words[i];

            if(hashMap.containsKey(words[i]) || (beforeWord.charAt(beforeWord.length()-1) != nowWord.charAt(0)) || nowWord.length() == 1) {
//                System.out.println(beforeWord + " " + nowWord + " " + i);
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }

            hashMap.put(nowWord, true);
            beforeWord = nowWord;
        }

        return answer;
    }
}