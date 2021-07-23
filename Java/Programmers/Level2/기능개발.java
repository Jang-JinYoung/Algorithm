//https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int days[] = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            days[i] = (int)Math.ceil(((double)100-progresses[i])/speeds[i]);
        }

        int day = days[0];
        int index = 0;
        list.add(index, 1);
        for(int i=1; i<days.length; i++) {

            if(day < days[i]) {
                day = days[i];
                index++;
                list.add(index, 1);
            } else {
                list.set(index, list.get(index)+1);
            }

        }

        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}