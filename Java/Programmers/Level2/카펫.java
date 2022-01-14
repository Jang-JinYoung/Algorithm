// https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        for(int i=2; i<sum/2; i++) {
            int x = i;
            if(sum%x == 0) {
                int y = sum/x;

                if( (x-2) * (y-2) == yellow) {
                    answer[0] = y;
                    answer[1] = x;
                    return answer;
                }
            }
        }


        return answer;
    }
}