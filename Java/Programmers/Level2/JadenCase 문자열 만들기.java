// https://programmers.co.kr/learn/courses/30/lessons/12951

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String arr[] = s.split(" ", -1);

        for(int i=0; i<arr.length; i++) {

            for(int j=0; j<arr[i].length(); j++) {
                if(j == 0 ) {
                    if('a' <= arr[i].charAt(j) && arr[i].charAt(j) <= 'z') {
                        answer.append(Character.toUpperCase(arr[i].charAt(j)));
                    } else {
                        answer.append(arr[i].charAt(j));
                    }
                } else {
                    if('A' <= arr[i].charAt(j) && arr[i].charAt(j) <= 'Z') {
                        answer.append(Character.toLowerCase(arr[i].charAt(j)));
                    } else {
                        answer.append(arr[i].charAt(j));
                    }
                }
            }
            answer.append(" ");
        }
        
        return answer.toString().substring(0, answer.length()-1);
    }
}