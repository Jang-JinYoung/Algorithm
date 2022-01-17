// https://programmers.co.kr/learn/courses/30/lessons/84512

class Solution {
    public int solution(String word) {
        int answer = word.length();

        int [] arr = {781, 156, 31, 6, 1};
        for(int i=0; i<word.length(); i++) {
            switch (word.charAt(i)) {
                case 'E': answer += arr[i]; break;
                case 'I': answer += arr[i] * 2; break;
                case 'O': answer += arr[i] * 3; break;
                case 'U': answer += arr[i] * 4; break;
            }
        }
        return answer;
    }
}

/*
class Solution {
    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}
*/