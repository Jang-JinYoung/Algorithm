//https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int answer = 0;

        //무브 움직인 개수만큼
        for(int i=0; i<moves.length; i++) {
            int n = 0;
            //그 라인에 맞게 위에서부터 아래로
            for(int j=0; j<board[moves[i]-1].length; j++) {
                if(board[j][moves[i]-1] != 0) {
                    n = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;

                    if(stack.peek() == n) {
                        stack.pop();
                        answer = answer + 2;
                    } else {
                        stack.push(n);
                    }

                    break;
                }
            }
        }

        return answer;
    }
}