import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/12973

class Solution
{
    public static int solution(String s)
    {
        int answer = 0;

        LinkedList<Character> list = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            list.add(s.charAt(i));
        }

        int size = list.size();


        //		String s = "baabaa";
        for(int i=0; i<size-1; i++) {

            if(list.get(i) == list.get(i+1)) {
                list.remove(i);
                list.remove(i);
                i=0;
                size = size-2;
            }

        }

        if(list.get(0) == list.get(1)) {
            list.remove(0);
            list.remove(0);
        }


        if(list.size() == 0)
            return 1;
        else
            return 0;

    }
}