//https://leetcode.com/problems/add-digits/

class Solution {
    
    public int addDigits(int num) {

        int res = num == 0 ? 0 : cal(num);

        return res;
    }

    public int cal(int num) {

        int sum = 0;
        while(num != 0) {
            sum = sum + (num%10);
            num = num / 10;
        }

        if(sum >= 10)
            return cal(sum);
        else
            return sum;
    }
}