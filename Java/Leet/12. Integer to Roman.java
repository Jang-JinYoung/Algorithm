//https://leetcode.com/problems/integer-to-roman/

class Solution {
    public String intToRoman(int num) {

        String res = "";
        while (num != 0) {

            if(num >= 1000) {
                num = num - 1000;
                res = res + "M";
            } else if(num >= 900) {
                num = num - 900;
                res = res + "CM";
            } else if(num >= 500) {
                num = num - 500;
                res = res + "D";
            } else if(num >= 400) {
                num = num - 400;
                res = res + "CD";
            } else if(num >= 100) {
                num = num - 100;
                res = res + "C";
            } else if(num >=90) {
                num = num - 90;
                res = res + "XC";
            } else if(num >= 50) {
                num = num - 50;
                res = res + "L";
            } else if(num >= 40) {
                num = num - 40;
                res = res + "XL";
            } else if(num >= 10) {
                num = num - 10;
                res = res + "X";
            } else if(num >= 9) {
                num = num - 9;
                res = res + "IX";
            } else if(num >= 5) {
                num = num - 5;
                res = res + "V";
            } else if(num >= 4) {
                num = num - 4;
                res = res + "IV";
            } else {
                num = num - 1;
                res = res + "I";
            }
        }

        return res;

    }
}