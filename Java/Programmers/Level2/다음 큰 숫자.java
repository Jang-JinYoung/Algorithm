// https://programmers.co.kr/learn/courses/30/lessons/12911

class Solution {
    public int solution(int n) {
        int answer = n+1;

        int mainOneCnt = getOneCnt(n);

        while(true) {
            int diffOneCnt = getOneCnt(answer);

            if(mainOneCnt == diffOneCnt) {
                break;
            } else {
                answer++;
            }
        }

        return answer;
    }


    private int getOneCnt(int n) {

        String binary = Integer.toBinaryString(n);
        char [] arr = binary.toCharArray();
        int count = 0;

        for(char digit : arr) {
            if(digit == '1') count++;
        }

        return count;
    }
}