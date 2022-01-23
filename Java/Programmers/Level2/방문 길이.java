// https://programmers.co.kr/learn/courses/30/lessons/49994

import java.util.HashSet;

class Solution {

    //상 하 좌 우
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    static int x = 5;
    static int y = 5;

    static int answer = 0;
    public int solution(String dirs) {

        HashSet<String> visited = new HashSet<>();

        for(int i=0; i<dirs.length(); i++) {
            char move = dirs.charAt(i);

            switch (move) {
                case 'U':
                    isVisited(visited, 0);
                    break;
                case 'D':
                    isVisited(visited, 1);
                    break;
                case 'L':
                    isVisited(visited, 2);
                    break;
                case 'R':
                    isVisited(visited, 3);
                    break;
            }
        }
        return answer;
    }

    private void isVisited(HashSet<String> visited, int move) {

        int newX = x + dx[move];
        int newY = y + dy[move];

        if( 0 <= y+dy[move] && y+dy[move] <= 10 // 세로축을 넘어가지 않는 상태
            && 0 <= x+dx[move] && x+dx[move] <= 10) {// 가로축을 넘어가지 않는상태

            String start = y+","+x;
            String end = newY+","+newX;
            x = newX;
            y = newY;
            if(!visited.contains(start+","+end) || !visited.contains(end+","+start)) {
                visited.add(start+","+end);
                visited.add(end+","+start);
                answer++;
            }
        }
    }
}