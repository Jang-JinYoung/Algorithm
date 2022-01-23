// https://programmers.co.kr/learn/courses/30/lessons/12940

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);
        int lcm = gcd * n/gcd * m/gcd;

        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }

    public int gcd(int n, int m) {
        int x = Math.max(n,m);
        int y = Math.min(n,m);

        while(x%y != 0) {
            int r = x%y;
            x = y;
            y = r;
        }

        return y;
    }
}