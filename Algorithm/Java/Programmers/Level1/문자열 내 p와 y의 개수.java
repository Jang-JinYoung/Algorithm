//https://programmers.co.kr/learn/courses/30/lessons/12916

class Solution {
    boolean solution(String s) {

        int pcnt=0;
        int ycnt=0;
        boolean answer = true;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P' )
                pcnt++;
            if(s.charAt(i) == 'y'  || s.charAt(i) == 'Y')
                ycnt++;
        }

        if(pcnt == ycnt)
            return true;
        else
            return false;

    }
}