// https://programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];


        Set<String> set = Arrays.stream(gems).distinct().collect(Collectors.toSet());
        if(set.size() == 1) {
            return new int[]{1, 1};
        } else {
            HashMap<String, Integer> map = new HashMap<>();
            int left = 0;
            int right = 0;

            int distance = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;

            while(true) {
                if(map.size() == set.size()) {
                    map.put(gems[left], map.get(gems[left])-1);

                    if(map.get(gems[left]) == 0) {
                        map.remove(gems[left]);
                    }
                    left++;
                } else if(right == gems.length) { // 끝까지 도달하였을때
                    break;
                } else {//한개씩 추가해줌
                    map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                    right++;
                }
                System.out.println(map);
                if(map.size() == set.size()) {
                    if (right-left < distance){
                        distance = right-left;
                        start = left+1;
                        end = right;
                    }
                }
            } // while

            answer[0] = start;
            answer[1] = end;
        }

        return answer;
    }
}