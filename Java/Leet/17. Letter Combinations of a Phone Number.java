//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {

    Map<Character, String> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty() || digits.length() ==0) {
            return new ArrayList<>();
        }
        /* 초기 세팅 시작 */
        list.clear();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String words[] = new String[digits.length()];
        for(int i=0; i<digits.length(); i++) {
            char digit = digits.charAt(i);
            words[i] = map.get(digit);
        }

        /* 초기 세팅 끝 */

        boolean visited[][] = new boolean[words.length][4];
        
        combination(words, visited, 0, "", digits.length());


        return list;
    }

    static void combination(String[] words, boolean visited[][], int start,  String s, int r) {
        
        if(s.length() == r) {
            list.add(s);
        } else {
            for(int i=start; i<words.length; i++) {
                for(int j=0; j<words[i].length(); j++) {
                    visited[i][j] = true;
                    combination(words, visited, i+1, s + words[i].charAt(j), r);
                    visited[i][j] = false;
                }
            }
        }

    }
}