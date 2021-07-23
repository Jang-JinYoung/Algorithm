class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int len[] = new int[strs.length];

        for(int i=0; i<strs.length; i++) {
            len[i] = strs[i].length();
        }

        int min = Arrays.stream(len).min().getAsInt();

        String s[] = new String[strs.length];

        String prefix = "";

        boolean bool = true;

        for(int i=0; i<min; i++) {

            for(int j=0; j<strs.length; j++) {
                s[j] = strs[j].charAt(i) + "";
            }

            for(int j=1; j<s.length; j++) {
                if(!s[j-1].equals(s[j])) {
                    bool = false;
                }
            }

            if(bool) {
                prefix = prefix + s[0];
            }
            else
                break;

        }
        
        return prefix;
    }
}