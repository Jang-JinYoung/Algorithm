//https://programmers.co.kr/learn/courses/30/lessons/17682

import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int flag = 0;

        ArrayList<String> darts = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();


        for(int i=0; i<dartResult.length(); i++) {

            char c = dartResult.charAt(i);
            String dart = "";

            if((c >= '0' && c <= '9') && flag == 0) {
                start = i;
                flag = 1;
            }

            if(c == 'S' || c == 'D' || c == 'T') {

                end = i;

                dart = dartResult.substring(start, end+1);

                darts.add(dart);
                start = 0;
                end = 0;
                flag = 0;
            }

            if(c == '*' || c == '#') {
                darts.add(c+"");
            }

        }

        for(String dart : darts) {

            //점수만 뺀다
            if(dart.equals("*")  || dart.equals("#")) {

                if(dart.equals("*")) {
                    if(scores.size() == 1) {
                        scores.set(0, scores.get(0)*2);
                    } else {
                        for(int i=scores.size()-2; i<scores.size(); i++) {
                            scores.set(i, scores.get(i)*2);
                        }
                    }
                } else {
                    scores.set(scores.size()-1, scores.get(scores.size()-1)*-1);
                }
            } else {

                //숫자만 빼낸다
                int num = Integer.parseInt(dart.substring(0, dart.length()-1));
                char c = dart.charAt(dart.length()-1);

                //마지막문자
                if(c == 'S') {
                    num = (int) Math.pow(num, 1);
                } else if(c == 'D') {
                    num = (int) Math.pow(num, 2);
                } else {
                    num = (int) Math.pow(num, 3);
                }

                scores.add(num);
            }
        }

        for(Integer score : scores) {
            answer += score;
        }

        return answer;
    }
}