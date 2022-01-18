// https://programmers.co.kr/learn/courses/30/lessons/43105

import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1; i<triangle.length; i++) {
            //왼대각선
            for(int j=0; j<1; j++) {
                triangle[i][j] += triangle[i-1][j];
                triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            }

            if(triangle[i].length > 2) {
                for(int j=1; j<triangle[i].length-1; j++) {
                    int max = Integer.max(triangle[i-1][j-1], triangle[i-1][j]);
                    triangle[i][j] += max;
                }
            }
        }

        answer = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();


        return answer;
    }
}
