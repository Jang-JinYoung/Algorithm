// https://programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {


        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, List<Album>> albumMap = new HashMap<String, List<Album>>();

        // 해쉬맵 삽입
        for(int i=0; i< genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);

            Album album = new Album(i, plays[i]);
            if(albumMap.containsKey(genres[i])) {
                albumMap.get(genres[i]).add(album);
            } else {
                List<Album> list = new ArrayList<>();
                list.add(album);
                albumMap.put(genres[i], list);
            }
        }

        int size = 0;
        for(String key : albumMap.keySet()) {
            if(albumMap.get(key).size() == 1) {
                size += 1;
            } else {
                size += 2;
            }
        }
        int [] answer = new int[size];
        
        //해쉬맵 키/밸류 정렬
        int i = 0;
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        entryList.sort(((o1, o2) -> hashMap.get(o2.getKey()) - hashMap.get(o1.getKey())));
        for(Map.Entry<String, Integer> entry : entryList){
            //리스트 정렬
            albumMap.get(entry.getKey()).sort((a, b) -> b.play - a.play);

            if(albumMap.get(entry.getKey()).size() == 1) {
                answer[i++] = albumMap.get(entry.getKey()).get(0).idx;
            } else {
                answer[i++] = albumMap.get(entry.getKey()).get(0).idx;
                answer[i++] = albumMap.get(entry.getKey()).get(1).idx;
            }
        }
        return answer;
    }
}

class Album{
    int idx;
    int play;

    public Album(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idx=" + idx +
                ", play=" + play +
                '}';
    }


}