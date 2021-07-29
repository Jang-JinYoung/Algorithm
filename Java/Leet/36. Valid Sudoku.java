//https://leetcode.com/problems/valid-sudoku/


class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Character, Integer> map = new HashMap<>();

        //가로 검사
        for(int i=0; i<board.length; i++) {
            map.clear();
            for(int j=0; j<board[i].length; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 1) + 1);
            }
            Object keySet[] = map.keySet().toArray();

            for(Object key : keySet) {
                if(map.get(key) > 2 && (char) key != '.') {
                    return false;
                }
            }
        }


        //세로 검사
        for(int i=0; i<board.length; i++) {
            map.clear();
            for(int j=0; j<board[i].length; j++) {
                map.put(board[j][i], map.getOrDefault(board[j][i], 1) + 1);
            }
            Object keySet[] = map.keySet().toArray();

            for(Object key : keySet) {
                if(map.get(key) > 2 && (char) key != '.') {
                    return false;
                }
            }
        }
        
        //평방 검사
        //가로 세로
        int row = 0, col = 0, idxCol = 0, idxRow = 0;
        for(int i=0; i<board.length; i++) {

            map.clear();
            row =  idxRow;

            for(int j=0; j<board.length; j++) {


                col = idxCol + j%3;

                map.put(board[row][col], map.getOrDefault(board[row][col], 1) + 1);

                if((j+1)%3 == 0) {
                    row = row + 1;
                    col = idxCol;
                }

            }
            idxCol = idxCol+3;

            if(idxCol == 9) {
                idxCol=0;
                idxRow+=3;
            }


            Object keySet[] = map.keySet().toArray();

            for(Object key : keySet) {
                if(map.get(key) > 2 && (char) key != '.') {
                    System.out.println(map);
                    return false;
                }
            }
        }

        return true;
    }
}