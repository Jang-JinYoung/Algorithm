import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/72410
class Solution {

    public String solution(String new_id) {
        String answer = "";
        LinkedList<Character> list = new LinkedList<Character>();


        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String str = new_id.toLowerCase();


        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z') {
                list.add(c);
            } else if(c >= '0' && c <= '9') {
                list.add(c);
            } else if(c == '-' || c == '_' || c == '.') {
                list.add(c);
            }

        }



        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) == '.' && list.get(i+1) == '.') {

                list.remove(i);

                i = -1;
            }
        }



        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(list.size() == 1) {
            if(list.getFirst() == '.')
                list.remove(0);
        } else {
            if(list.getFirst() == '.')
                list.remove(0);
            if(list.getLast() == '.') {
                list.remove(list.size()-1);
            }
        }



        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(list.size() == 0)
            list.add('a');

//		//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//	    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        if(list.size() > 15) {

            while(list.size() != 15) {
                list.remove(list.size()-1);
            }


            if(list.getLast() == '.')
                list.remove(list.size()-1);
        }




        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(list.size() < 3) {
            for(int i=list.size(); i<3; i++) {
                list.add(list.get(list.size()-1));
            }
        }

        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}