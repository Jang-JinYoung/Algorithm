//https://leetcode.com/problems/word-pattern/

class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        String word [] = s.split(" ");
        
        
        if(pattern.length() != word.length)
            return false;


        for(int i=0; i<pattern.length(); i++) {
            Character key = pattern.charAt(i);

            if(map.get(key) == null) {
                if(map.containsValue(word[i])) {
                    return false;
                } else {
                    map.put(key, word[i]);
                }
            } else {
                if(!map.get(key).equals(word[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}