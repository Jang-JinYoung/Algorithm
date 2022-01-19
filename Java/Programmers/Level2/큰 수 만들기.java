// https://programmers.co.kr/learn/courses/30/lessons/42883

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //원하는 문자열은 number.length() - k;
        int size = number.length()-k;

        stack.push(number.charAt(0));
        for(int i=1; i<number.length(); i++) {
            while(k != 0 && stack.peek() < number.charAt(i)) { // top 값과 현재 값 비교
                stack.pop(); //꼭대기값 제거
                k--; //뺴준만큼 k값 제거
                if(stack.isEmpty()) // 스택이 비어있다면
                    break; // 종료
            }
            stack.push(number.charAt(i));
        }


        while(!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }

        answer = new StringBuilder(answer.substring(0, size));

        return answer.toString();
    }
}