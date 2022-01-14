// https://programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        int answer = clothes.length;

        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 0) + 1);
        }

        if(hashMap.size() > 1) {
            int count = 1;
            for(String key : hashMap.keySet()) {
                count *= hashMap.get(key) + 1;
            }
            answer = count-1;
        }

        return answer;
    }

}
