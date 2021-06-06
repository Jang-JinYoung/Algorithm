//https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //해쉬맵
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //동명이인일경우 +1
        for(String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);

        for(String player : completion)
            hm.put(player, hm.get(player)-1);

        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}