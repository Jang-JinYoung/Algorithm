import java.util.Arrays;


//https://programmers.co.kr/learn/courses/30/lessons/17681
class Solution {

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = {};


        String [] map1 = setMap(arr1, n);
        String [] map2 = setMap(arr2, n);


        answer = makeMap(map1, map2, n);

        return answer;

    }

    private static String[] makeMap(String[] map1, String[] map2, int n) {

        String map[] = new String[n];

        for(int i=0; i<n; i++) {
            String line = "";

            for(int j=0; j<n; j++) {
                if(map1[i].charAt(j) == '#' || map2[i].charAt(j) == '#') {
                    line = line+"#";
                } else {
                    line = line + " ";
                }
            }

            map[i] = line;
        }

        return map;
    }

    private static String[] setMap(int[] arr, int n) {

        String map[] = new String[n];

        for(int i=0; i<arr.length; i++) {

            String bina = Integer.toBinaryString(arr[i]);
            if(bina.length() < n) {
                for(int j=bina.length(); j<n; j++) {
                    bina = "0" + bina;
                }
            }


            bina = bina.replace("0", " ");
            bina = bina.replace("1", "#");

            map[i] = bina;

        }



        return map;
    }
}