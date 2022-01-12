// https://programmers.co.kr/learn/courses/30/lessons/12930
class Solution {
    public String solution(String s) {

        String [] words = s.split(" ", -1);
        StringBuilder answer = new StringBuilder();

        for(String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {//짝수 대문자
                    answer.append((word.charAt(i) + "").toUpperCase());
                } else {//홀수 소문자
                    answer.append((word.charAt(i) + "").toLowerCase());
                }
            }
            answer.append(" ");
        }

        return answer.toString().substring(0, answer.length() - 1);
    }
}