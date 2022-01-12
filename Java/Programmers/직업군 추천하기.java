//https://programmers.co.kr/learn/courses/30/lessons/84325?language=java

import java.util.*;


class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {

        Map<String, Map<String, Integer>> map = new HashMap<>();
        String answer = "";

        for(int i=0; i< table.length; i++) {
            //띄어쓰기 기준으로 자르고
            String line[] = table[i].split(" ");
            //1~6까지 값을 배열로 변환 0은 컨텐츠값
            String skills[] = Arrays.copyOfRange(line, 1, 6);

            //리스트형식으로 만들어준 후 (reverse 사용하기 위함)
            List<String> list = Arrays.asList(skills);
            //reverse 리스트 역순
            Collections.reverse(list);
            //역순으로 된걸 Array 재할당
            skills = list.toArray(skills);

            Map<String, Integer> skillMap = new HashMap<>();
            for(int j=0; j<skills.length; j++) {
                skillMap.put(skills[j], j+1);
            }
            map.put(line[0], skillMap);
        }

        String keys[] = map.keySet().toArray(new String[map.size()]);

        int highScore = 0;
        for(String key : keys) {
            int sumScore = 0;
            Map<String, Integer> skillMap = map.get(key);
            for(int i=0; i< languages.length; i++) {
                int score = 0;
                if(skillMap.get(languages[i]) == null) {
                    score = 0;
                } else {
                    score = skillMap.get(languages[i]);
                }
                sumScore += (score*preference[i]);
                if(highScore <= sumScore) {
                    if(highScore == sumScore && answer.compareTo(key) > 0) {
                        answer = key;
                    } else if(highScore < sumScore) {
                        highScore = sumScore;
                        answer = key;
                    }
                }
            }
//            System.out.println(answer + " " + key + " " + sumScore);
        }


        return answer;
    }
}