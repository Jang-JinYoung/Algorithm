//https://programmers.co.kr/learn/courses/30/lessons/12932

import java.util.ArrayList;

class Solution {
    public Integer[] solution(long n) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        while(n > 0) {

            list.add((int) (n%10));
            n = n/10;
        }



        Integer[] answer = list.toArray(new Integer[list.size()]);

        return list.toArray(new Integer[list.size()]);
    }
}