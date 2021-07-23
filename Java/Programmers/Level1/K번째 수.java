//https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

class Solution {

    public int[] solution(int[] array, int[][] commands) {

        int answer[] = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            //배열
            int tempArray[] = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            //정렬
            Arrays.sort(tempArray);

            answer[i] = tempArray[commands[i][2]-1];

        }

        return answer;
    }
}