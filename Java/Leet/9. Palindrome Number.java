class Solution {
    public boolean isPalindrome(int x) {
        
        String res = x + "";

        for(int i=0; i<res.length(); i++) {
            if(res.charAt(i) != res.charAt(res.length()-1-i))
                return false;
        }
        return true;
        
    }
}