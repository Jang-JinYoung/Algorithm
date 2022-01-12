// https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.LinkedList;
import java.util.List;

class Solution {

    static int answer = 0;
    List<Integer> list = new LinkedList<>();

    public int solution(String numbers) {


        char [] arr = new char[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        String names = "";
        boolean [] visited = new boolean[arr.length];

        permutation(arr, names, visited);

        return list.size();
    }

    private void permutation(char[] arr, String names, boolean[] visited) {

        if(names.length() <= arr.length && names.length() != 0) {
            int num = Integer.parseInt(names);
            if(isPrime(num) && !list.contains(num)) {
                list.add(num);
            }
        }
        for(int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String name = names + arr[i];
                permutation(arr, name, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }

        for(int i=2; i*i<=num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}