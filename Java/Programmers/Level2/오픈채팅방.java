//https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        String[] answer = new String[record.length];
        Map<String, Log> map = new HashMap<>();

        for(int i=0; i<record.length; i++) {
            String split[] = record[i].split(" ");

            //split[0] => enter, leave, change
            if(split[0].equals("Enter")) {//Enter

                if(map.get(split[1]) == null) {//기존에 들어온적 없는 아이디
                    List<Integer> seqs = new ArrayList<>(); //로그 seq 만들어 줌
                    seqs.add(i);   //로그 추가
                    Log log = new Log(split[1], seqs, split[2]); //uid, log seq, 닉네임

                    map.put(split[1], log); //로그 넣어준다.
                    answer[i] = split[2] + "님이 들어왔습니다."; //입장
                } else {//기존에 들어온 아이디
                    Log log = map.get(split[1]);    //기존에 있던 log 들고 온다.

                    List<Integer> seqs = log.seqs;  //seq를 가져온다.

                    //seq를 기준으로 replace
                    for(Integer seq : seqs) {
                        answer[seq] = answer[seq].replace(log.ninckname, split[2]);
                    }

                    answer[i] = split[2] + "님이 들어왔습니다.";

                    seqs.add(i);  //그리고 새로이 추가
                    log = new Log(split[1], seqs, split[2]);  //log 수정
                    map.put(split[1], log);
                }
            } else if(split[0].equals("Leave")) {//Leave
                Log log = map.get(split[1]);
                List<Integer> seqs = log.seqs;
                seqs.add(i);

                answer[i] = log.ninckname+"님이 나갔습니다.";
                log = new Log(split[1], seqs, log.ninckname);
                map.put(split[1], log);
            } else {//Change
                Log log = map.get(split[1]);
                List<Integer> seqs = log.seqs;

                for(Integer seq : seqs) {
                    answer[seq] = answer[seq].replace(log.ninckname, split[2]);
                }

                log = new Log(split[1], seqs, split[2]);
                map.put(split[1], log);
            }
        }

        int idx = 0;
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == null)
                idx++;
        }

        String[] res = new String[record.length-idx];
        idx = 0;
        for(int i=0; i<answer.length; i++) {
            if(answer[i] != null) {
                res[idx++] = answer[i];
            }
        }

        return res;
        
    }

}

class Log {
    String id;
    List<Integer> seqs;
    String ninckname;

    public Log(String id, List<Integer> seqs, String ninckname) {
        this.id = id;
        this.seqs = seqs;
        this.ninckname = ninckname;
    }
}