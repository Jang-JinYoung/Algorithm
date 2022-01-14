// https://programmers.co.kr/learn/courses/30/lessons/49993#fnref1

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            String temp = skill_tree;

            for(int i=0; i<skill_tree.length(); i++) {
                String s = skill_tree.substring(i, i+1); // 한개씩 자른다
                if(!skill.contains(s)) {// 스킬 트리안에 포함되어 있지 않은 단어라면
                    temp = temp.replace(s, ""); // 지운다
                }
            }
            if(skill.indexOf(temp) == 0) {
                System.out.println(skill.indexOf(temp) + " " + temp);
                answer++;
            }
        } // for

        return answer;
    }
}