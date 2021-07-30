//https://programmers.co.kr/learn/courses/30/lessons/12985

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        ArrayList<Integer> winner = new ArrayList<>();

        int k = (int) (Math.log10(n) / Math.log10(2));
        boolean bool = true;

        for(int i=k; i>0; i--) {

            for(int j=1; j<=(int) Math.pow(2, i); j=j+2) {
                if((j==a && j+1 == b) || (j==b && j+1 == a)) {
                    bool = false;
                    break;
                } else {
                    if(j == a || j == b) {
                        if(j==a) {
                            a = winner.size()+1;
                            winner.add(a);
                        } else {
                            b = winner.size()+1;
                            winner.add(b);
                        }
                    } else if (j+1 == a || j+1 == b){
                        if(j+1==a) {
                            a = winner.size()+1;
                            winner.add(a);
                        } else {
                            b = winner.size()+1;
                            winner.add(b);
                        }
                    } else {
                        winner.add(winner.size()+1);
                    }
                }
            }//2중 for
            winner.clear();

            if(bool)
                answer++;
            else
                break;
        }


        //3일때 1라운드 2일떄 2라운드 1일떄 3라운드
        //4-1 3-2 2-2 1-4

        return answer;
    }
}