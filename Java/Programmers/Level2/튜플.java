// https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {

        String [] arr = s.replace("},{", "/").replaceAll("[{}]", "").split("/");
        int[] answer = new int[arr.length];

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            String [] arr2 = arr[i].split(",");
            for(int j=0; j<arr2.length; j++) {
                if(!set.contains(Integer.parseInt(arr2[j]))) {
                    set.add(Integer.parseInt(arr2[j]));
                    answer[i] = Integer.parseInt(arr2[j]);
                }
            }
        }

        return answer;
    }
}