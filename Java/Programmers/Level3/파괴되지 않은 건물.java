// https://programmers.co.kr/learn/courses/30/lessons/92344

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        // skill의 각 행은 [type, r1, c1, r2, c2, degree]형태를 가지고 있습니다.
        // type 1 혹은 2입니다.
        //  type 1일 경우는 적의 공격을 의미합니다. 건물의 내구도를 낮춥니다.
        //  type 2일 경우는 아군의 회복 스킬을 의미합니다. 건물의 내구도를 높입니다.
        int m=board.length, n=board[0].length, ret=0;
        int[][] sum = new int[m+1][n+1];
        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 1) degree = -degree;
            sum[r1][c1] += degree;
            sum[r2+1][c1] += degree*-1;
            sum[r1][c2+1] += degree*-1;
            sum[r2+1][c2+1] += degree;
        }
        
        // 좌->우
        for(int j=1 ; j<n ; j++) {
            for(int i=0 ; i<m ; i++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        // 상->하
        for(int i=1; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }

        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }


}