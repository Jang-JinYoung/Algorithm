//https://leetcode.com/problems/find-the-difference

class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<t.length()-1; i++) {
            char c1 = t.charAt(i);
            char c2 = s.charAt(i);

            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }
        map1.put(t.charAt(t.length()-1), map1.getOrDefault(t.charAt(t.length()-1), 0) + 1);

        Character[] keySet = map2.keySet().toArray(new Character[0]);
        
        for(Character key : keySet) {
            if(map1.get(key) != map2.get(key))
                return key;
        }

        return t.charAt(t.length()-1);
    }
}