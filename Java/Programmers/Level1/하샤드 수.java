https://programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String number = x + "";

        int sum = 0;
        for(int i=0; i<number.length(); i++) {
            sum = sum + Integer.parseInt(number.charAt(i)+"");
        }

        if(x%sum == 0)
            return true;
        else
            return false;
    }
}
