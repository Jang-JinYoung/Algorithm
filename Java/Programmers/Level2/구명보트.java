// https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        //구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고
        int j = 0;

        for(int i=people.length-1; i>=0; i--) {
            if(people[i] + people[j] <= limit) j++;
            answer++;

            if(i <= j) {
                break;
            }
        }
        return answer;
    }
}