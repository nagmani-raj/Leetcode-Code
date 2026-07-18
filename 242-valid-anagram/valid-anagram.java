class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] dp = new int[26];

        for(int i=0; i<s.length(); i++){
            dp[s.charAt(i)-'a']++;
            dp[t.charAt(i)-'a']--;
        }

        for(int ch : dp){
            if(ch != 0) return false;
        }

        return true;
    }
}