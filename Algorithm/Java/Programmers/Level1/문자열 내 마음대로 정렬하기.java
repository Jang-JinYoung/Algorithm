//https://programmers.co.kr/learn/courses/30/lessons/12915

class Solution {
    public String[] solution(String[] strings, int n) {


        String answer[] = new String[strings.length];

        for(int i=0; i<strings.length; i++) {

            char c1 = strings[i].charAt(n);
            int idx = i;
            String s1 = strings[i];

            for(int j=i+1; j<strings.length; j++) {

                char c2 = strings[j].charAt(n);
                String s2 = strings[j];


                if(c1 > c2) {
                    c1 = c2;
                    s1 = s2;
                    idx = j;
                } else if(c1 == c2 && s1.compareTo(s2) > 0) {
                    s1 = s2;
                    idx = j;
                }

            }//2중 for

            String temp = strings[i];
            strings[i] = strings[idx];
            strings[idx] = temp;

        }

        System.out.println("abcde".compareTo("abc"));

        for(int i=0; i<strings.length; i++)
            answer[i] = strings[i];

        return answer;
    }
}