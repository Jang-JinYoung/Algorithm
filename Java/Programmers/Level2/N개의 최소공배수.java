// https://programmers.co.kr/learn/courses/30/lessons/12953

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            // 최소 공배수
            answer = answer * arr[i]/gcd;
        }
        return answer;
    }
    
    //유클리드 호제법 -> 최소공약수
    public static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while(x % y != 0) {
            int r = x%y;
            x = y;
            y = r;
        }
        return y;
    }
}