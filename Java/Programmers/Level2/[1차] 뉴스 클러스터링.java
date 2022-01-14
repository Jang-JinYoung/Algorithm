// https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.HashMap;

class Solution {
    // 입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
    static int m = 0; // 분모
    public int solution(String str1, String str2) {

        int answer = 0;
        HashMap<String, Integer> str1Hashmap = Jaccard(str1);
        HashMap<String, Integer> str2Hashmap = Jaccard(str2);
        // 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1
        if(str1Hashmap.isEmpty() && str2Hashmap.isEmpty()) {
            return 65536;
        }
//        System.out.println(str1Hashmap);
//        System.out.println(str2Hashmap);
        int n = 0;

        for(String key : str1Hashmap.keySet()) {
            // 교집합 만들기 -> 분자
            if(str2Hashmap.containsKey(key)) {
                n += Math.min(str1Hashmap.get(key), str2Hashmap.get(key));
            }
        }
        // 합집합 만들기 -> a+b-(a교b)
        m = m - n;

//        System.out.println(Math.ceil((double) n/m * 65536));
        return (int) Math.floor((double) n/m * 65536);
    }

    private HashMap<String, Integer> Jaccard(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 중복 허용
        for(int i=0; i<str.length()-1; i++) {
            //입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
            //다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
            String s = str.substring(i, i+2).toUpperCase();
            //이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
            if(s.replaceAll("[^A-Z]", "").length() == s.length()) {
                hashMap.put(s, hashMap.getOrDefault(s, 0) +1);
                m++;
            }

        }
        return hashMap;
    }
}