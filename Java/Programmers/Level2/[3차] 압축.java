// https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public Integer[] solution(String msg) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        //길이가 1인 모든 단어를 포함하도록 사전 초기화
        for(char c ='A'; c<='Z'; c++) {
            hashMap.put(c+"", (c-'A')+1);
        }

        while(true) {
            // 다음 글자
            String nowWord = msg.substring(0, 1);

            String nextWord = "";
            for(int c=2; c<=msg.length(); c++) {
                nextWord = msg.substring(0, c);
                if(!hashMap.containsKey(nextWord)) {
                    hashMap.put(nextWord, hashMap.size()+1);
                    break;
                }
                nowWord = nextWord;
            }

            list.add(hashMap.get(nowWord));
            if(nowWord.length() == msg.length()) {
                break;
            }
            msg = msg.substring(nowWord.length(), msg.length());
        }

        Integer[] answer = list.toArray(new Integer[0]);

        return answer;
    }
}