// https://programmers.co.kr/learn/courses/30/lessons/87946

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int size = dungeons.length;
        boolean [] visited = new boolean[size];
        int [] arr = new int[size];

//        Arrays.sort(dungeons, ((o1, o2) -> o1[0] - o1[1]));

        permutations(dungeons, arr, visited, 0, size, k);

        return answer;
    }

    private void permutations(int[][] dungeons, int[] arr, boolean[] visited, int depth, int size, int k) {
        if(depth == size) {
            addList(arr, dungeons, k);
            return;
        }

        for(int i=0; i<size; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutations(dungeons, arr ,visited, depth+1, size, k);
                visited[i] = false;
            }
        }
    }

    private void addList(int[] arr, int[][] dungeons, int k) {

        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(dungeons[arr[i]][0] <= k) {
//                System.out.print(dungeons[arr[i]][0] + " " + k);
                k -= dungeons[arr[i]][1];
                count++;
            }
//            System.out.println();
        }

        if(count > answer) {
            answer = count;
        }
    }

}