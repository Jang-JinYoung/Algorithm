import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int user = id_list.length;
        int[] answer = new int[user];
        // 중복 신고 여부 확인
        boolean [][] visited = new boolean[user][user];
        // 몇번 신고 당했는지
        int [] reportCount = new int[user];
        // 누가 신고헀는지
        HashMap<String, List<String>> hashMap = new HashMap<>();
        // 유저 번호 해쉬맵
        HashMap<String, Integer> userNo = new HashMap<>();

        for(int i=0; i<id_list.length; i++) {
            userNo.put(id_list[i], i);
        }

        for (String s : report) {
            String[] users = s.split(" ");

            // 만약 신고하지 않았다면
            if (!visited[userNo.get(users[0])][userNo.get(users[1])]) {
                // 신고
                visited[userNo.get(users[0])][userNo.get(users[1])] = true;
                // 신고횟수 증가
                reportCount[userNo.get(users[1])]++;
                if (!hashMap.containsKey(users[1])) {
                    List<String> list = new LinkedList<>();
                    list.add(users[0]);
                    hashMap.put(users[1], list);
                } else {
                    hashMap.get(users[1]).add(users[0]);
                }
            }
        }

        for(int i=0; i<id_list.length; i++) {
            if(reportCount[i] >= k) { // k번 이상이면
                List<String> list = hashMap.get(id_list[i]);
                for(String id : list) {
                    answer[userNo.get(id)]++;
                }
            }
        }


        return answer;
    }
}