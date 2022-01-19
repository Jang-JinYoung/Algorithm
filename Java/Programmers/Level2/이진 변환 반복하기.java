// https://programmers.co.kr/learn/courses/30/lessons/70129

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            // 변환 과정에서 제거된 모든 0의 개수
            answer[1] += s.length() - s.replace("0", "").length();
            // x의 모든 0을 제거합니다.
            s = s.replace("0", "");

            // x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
            s = Integer.toBinaryString(s.length());
            // 이진 변환의 횟수
            answer[0]++;
        }
        return answer;
    }

}