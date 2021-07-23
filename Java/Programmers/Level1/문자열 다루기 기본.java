//https://programmers.co.kr/learn/courses/30/lessons/12918

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        int size = s.length();

        if(size == 4 || size == 6) {
            for(int i=0; i<s.length(); i++) {

                if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                    return false;
            }
            return true;
        }

        return false;
    }
}