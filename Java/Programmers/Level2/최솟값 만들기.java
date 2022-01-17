// https://programmers.co.kr/learn/courses/30/lessons/12941
 
import java.util.Arrays;

class Solution {
    public int solution(int [] A, int [] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        int j = B.length-1;
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[j--];
        }

        return answer;
    }
}