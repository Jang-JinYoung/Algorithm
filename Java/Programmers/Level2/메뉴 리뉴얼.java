// https://programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {

    static HashMap<String, Integer> hashMap = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (String order : orders) {
            int r = order.length();
            boolean[] visited = new boolean[r];
            combination(visited, order, 0);
        }

        checkCourse(course);

        answer = list.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }

    private void checkCourse(int[] course) {

        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int i=0; i<course.length; i++) {
            int max = 0;

            for(String key : hashMap.keySet()) {
                if(key.length() == course[i] && hashMap.get(key) > 1 && max < hashMap.get(key)) {
                    max = hashMap.get(key);
                }
            }

            for(String key:hashMap.keySet()) {
                if(hashMap.get(key) == max && key.length() == course[i]) {
                    list.add(key);
                }
            }
        }


    }

    private void combination(boolean[] visited, String order, int start) {

        addToCourse(visited, order);
        for(int i=start; i<order.length(); i++) {
            visited[i] = true;
            combination(visited, order, i+1);
            visited[i] = false;
        }
    }

    private void addToCourse(boolean[] visited, String order) {
        StringBuilder course = new StringBuilder();

        for(int i=0; i<order.length(); i++) {
            if(visited[i]) {
                course.append(order.charAt(i));
            }
        }

        if(course.length() > 1) {
            char [] temp = course.toString().toCharArray();
            Arrays.sort(temp);
            course.delete(0, course.toString().length());
            for(int i=0; i<temp.length; i++) {
                course.append(temp[i]);
            }

            hashMap.put(course.toString(), hashMap.getOrDefault(course.toString(), 0) +1);
        }
    }
 }