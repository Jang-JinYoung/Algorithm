// https://programmers.co.kr/learn/courses/30/lessons/17687

class Solution {
    /*
    n 진법
    t 미리 구할 숫자의 개수
    m 게임 참가 인원
    p 튜브 순서
     */
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int num = 0;
        int tp = 0;
        while(answer.length() != t) {
            String s = makeNotation(num, n); // n 진법 만듦
            for(int i=0; i<s.length(); i++) {
                tp++;
                if(tp == p && answer.length() != t) {// 임시변수 tp가 p랑 같을때
                    answer.append(s.charAt(i));
                }
                if(tp == m) {//인원수만큼 찼을때
                    tp = 0;
                }
            }
            num++;
        }

        return answer.toString();
    }

    private String makeNotation(int num, int n) {
        StringBuilder notation = new StringBuilder();

        while(num >= 0) {
            String p = getString(num%n + "");
            num = num/n;
            notation.insert(0, p);

            if(num == 0)
                break;
        }

        return notation.toString();
    }

    private String getString(String s) {
        int num = Integer.parseInt(s);

        if(0 <= num && num < 10) {
            return s;
        } else {
            if(num == 10) {
                return "A";
            } else if(num == 11) {
                return "B";
            } else if(num == 12) {
                return "C";
            } else if(num == 13) {
                return "D";
            } else if(num == 14) {
                return "E";
            } else {
                return "F";
            }
        }
    }
}