// https://programmers.co.kr/learn/courses/30/lessons/82612

class Solution {

    public static long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1; i<=count; i++) {
            answer = answer + (i * price);
        }


        if(answer - money > 0)
            return answer-money;
        else
            return 0;
    }

}