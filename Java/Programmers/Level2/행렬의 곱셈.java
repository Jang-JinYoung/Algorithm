// https://programmers.co.kr/learn/courses/30/lessons/12949

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int m = arr1.length;
        int n = arr2[0].length;

        int[][] answer = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int value = 0;
                for(int k=0; k<arr1[i].length; k++) {
                    value += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = value;
            }
        }

        return answer;
    }
}