
//https://programmers.co.kr/learn/courses/30/lessons/76501
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        //true + false -
        for(int i=0; i<absolutes.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}