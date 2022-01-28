// https://programmers.co.kr/learn/courses/30/lessons/17679

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    char [][] gameBoard;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // 게임 보드 세팅
        gameBoard = new char[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            boolean [][] visited = new boolean[m][n];

            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(gameBoard[i][j] != '.' && isBlock(i, j)) {//isBlock -> 2*2 블록인지 우선 확인
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        visited[i+1][j] = true;
                    }
                }
            }

            int count = breakBlock(visited, m, n);
            answer += count;
            setBlockDown(m, n);


            if(count == 0) { // 더 이상 제거가 불가능하다면 종료
                break;
            }
        }

        return answer;
    }

    private int breakBlock(boolean[][] visited, int m, int n) {//블락 부셔준다.
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) {
                    gameBoard[i][j] = '.';
                    count++;
                }
            }
        }
        return count;
    }

    private void setBlockDown(int m, int n) {

        // 아래에서 위로 조회하면서 블럭이 아니면 블럭일때까지 내려준다
        for(int i=0; i<n; i++) { // 가로
            for(int j=m-1; j>=0; j--) { // 세로
                if(gameBoard[j][i] != '.') {
                    for(int k=j+1; k<m; k++) {//내려주는 로직
                        if(gameBoard[k][i] == '.') {
                            gameBoard[k][i] = gameBoard[k-1][i];
                            gameBoard[k-1][i] = '.';
                        }
                    } // 내리는 for
                }
            } // 확인 for
        } // 확인 for
    }

    private void printBoard() {
        for(int i=0; i<gameBoard.length; i++) {
            for(int j=0; j<gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private boolean isBlock(int i, int j) {
        return gameBoard[i][j] == gameBoard[i][j + 1] //오른쪽
                && gameBoard[i][j] == gameBoard[i + 1][j] //아래
                && gameBoard[i][j] == gameBoard[i + 1][j + 1]; // 대각선
    }
}
