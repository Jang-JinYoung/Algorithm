// https://programmers.co.kr/learn/courses/30/lessons/12899

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n != 0) {
            if(n % 3 == 0) {
                answer.insert(0, 4);
                n--;
            } else if(n % 3 == 1) {
                answer.insert(0, 1);
            } else {
                answer.insert(0, 2);
            }

            n = 3;
        }

        return answer.toString();
    }

}