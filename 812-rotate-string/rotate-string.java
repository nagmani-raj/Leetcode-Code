class Solution {
    public boolean rotateString(String s, String g) {
        if(s.length() != g.length()) return false;

        for(int i=0; i<s.length(); i++){
            s = s.substring(1) + s.charAt(0);

            if(s.equals(g)) return true;
        }

        return false;
    }
}