// https://programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Stack;

class Solution {
    public String solution(String w) {
        String answer = recursive(w);
        return answer;
    }

    private String recursive(String w) {

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(w.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = 0;
        for(int i=0; i<w.length(); i++) {
            if(w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if(left == right) {
                break;
            }
        }

        String u = w.substring(0, left+right);
        String v = w.substring(left+right);


        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면
        if(isCorrect(u)) {
            // v에 대해 1단계부터 다시 수행합니다.
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            u += recursive(v);
            return u;
        } else { //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            StringBuilder t = new StringBuilder();
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            t.append("(");
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            t.append(recursive(v));
            // 4-3. ')'를 다시 붙입니다.
            t.append(")");
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for(int i=1; i<u.length()-1; i++) {
                char c = u.charAt(i);
                if(c == '(') {
                    t.append(')');
                } else {
                    t.append('(');
                }
            }
            // 4-5. 생성된 문자열을 반환합니다.
            return t.toString();
        }
    }

    private boolean isCorrect(String u) {

        if(u.isEmpty()) { // 텅 비었다면 올바른 문자열
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        stack.push(u.charAt(0));
        for(int i=1; i<u.length(); i++) {
            if(u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(u.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }
}

