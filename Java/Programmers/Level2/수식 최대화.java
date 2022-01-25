// https://programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    static long answer = 0;
    public long solution(String expression) {

        //가지고 있는 숫자를 저장한다.
        LinkedList<Long> numList = new LinkedList<>();
        //가지고 있는 연산자를 저장한다.
        LinkedList<String> opList = new LinkedList<>();
        int idx = 0;
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(!('0' <= c && c <= '9')) {
                opList.add(c+"");
                numList.add(Long.parseLong(expression.substring(idx, i)));
                idx = i+1;
            }
        }
        numList.add(Long.parseLong(expression.substring(idx)));

        // 연산자 순위 리스트를 만든다.
        int n = 3;
        int [] arr = new int[n];
        boolean [] visited = new boolean[n];
        perm(arr, visited, numList, opList, n, 0);


        return answer;
    }

    private void perm(int[] arr, boolean[] visited, LinkedList<Long> numList, LinkedList<String> opList, int n, int depth) {

        if(depth == n) {
            // 우선순위 표 -> 0: +, 1: - 2: *
            solve(numList, opList, arr);
        } else {
            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    arr[depth] = i;
                    visited[i] = true;
                    perm(arr, visited,  numList, opList, n, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private void solve(LinkedList<Long> numList, LinkedList<String> opList, int[] arr) {

        LinkedList<Long> tempNumList = new LinkedList<>(numList);
        LinkedList<String> tempOpList = new LinkedList<>(opList);

        for(int i=0; i<arr.length; i++) {
            String op = getOp(arr[i]);
            for(int j=0; j<tempOpList.size(); j++) {
                if(tempOpList.get(j).equals(op)) {
                    long n1 = tempNumList.get(j);
                    long n2 = tempNumList.get(j+1);
                    long result = getCal(n1, n2, op);

                    tempNumList.remove(j+1); // 전자 삭제
                    tempNumList.remove(j); // 후자 삭제
                    tempOpList.remove(j); //후자 삭제

                    tempNumList.add(j, result);
                    j--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(tempNumList.get(0)));
    }

    private long getCal(long n1, long n2, String op) {

        if(op.equals("+")) {
            return n1+n2;
        } else if(op.equals("-")) {
            return n1-n2;
        } else {
            return n1*n2;
        }
    }

    private String getOp(int i) {
        if(i == 0) { // +
            return "+";
        } else if(i == 1) {// -
            return "-";
        } else {// *
            return "*";
        }
    }
}