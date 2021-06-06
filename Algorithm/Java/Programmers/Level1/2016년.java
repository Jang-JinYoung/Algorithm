//https://programmers.co.kr/learn/courses/30/lessons/12901

class Solution {
    public String solution(int a, int b) {

        a = a-1;
        b = b-1;
        String weeks[] = {"FRI","SAT", "SUN","MON","TUE","WED","THU"};

        int days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total = 0;

        for(int i=0; i<a; i++)
            total += days[i];

        total += b;
        String answer = weeks[total%7];
        return answer;
    }
}