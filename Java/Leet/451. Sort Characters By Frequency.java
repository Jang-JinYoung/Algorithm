// https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        String res = "";


        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        for(Character key : keySetList) {
            for(int i=0; i<map.get(key); i++) {
                res = res + key;
            }
        }


        return res;

    }
}