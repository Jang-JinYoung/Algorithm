//https://programmers.co.kr/learn/courses/30/lessons/12922

class Solution {
    public String solution(int n) {

        String answer = "";

        for(int i=1; i<=n; i++) {

            if(i%2 != 0)
                answer = answer + "수";
            else
                answer = answer + "박";
        }
        return answer;
    }
}