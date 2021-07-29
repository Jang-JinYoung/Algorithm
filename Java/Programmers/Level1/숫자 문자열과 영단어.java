//https://programmers.co.kr/learn/courses/30/lessons/81301
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Map<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");


        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            s = s.replace(key, map.get(key));
        }

        return Integer.parseInt(s);
    }
}