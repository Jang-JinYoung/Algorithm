// https://programmers.co.kr/learn/courses/30/lessons/12904

class Solution  {
    public int solution(String s) {

        char [] ch = s.toCharArray();
        int answer = s.length();

        for(int i=0; i<s.length()-1; i++) {
            for(int j=0; j<=i; j++) {
                if(isPalindrome(ch, j, ch.length-(i-j))) {
                    return answer-i;
                }
            }
        }

        return 1;
    }

    private boolean isPalindrome(char[] ch, int start, int end) {
        for(int i=0; i<(end-start)/2; i++) {
            if(ch[i+start] != ch[end-i-1]) {
                return false;
            }
        }

        return true;
    }
}