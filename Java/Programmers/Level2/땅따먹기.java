// https://programmers.co.kr/learn/courses/30/lessons/12913

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    int solution(int[][] land) {
        int N = land.length; // 세로
        int M = 4; // 가로

        for(int i=1; i<N; i++) {
            land[i][0] += getMax(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += getMax(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += getMax(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += getMax(land[i-1][0], land[i-1][1], land[i-1][2]);
        }

        return Arrays.stream(land[N-1]).max().getAsInt();
    }

    public int getMax(int i1, int i2, int i3) {

        return (i1 > i2) ? (Math.max(i1, i3)) : (Math.max(i2, i3));
    }
}