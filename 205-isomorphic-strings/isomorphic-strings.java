class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;
        HashMap<Character , Character> chs = new HashMap<>();
        HashMap<Character , Character> cht = new HashMap<>();

        for(int i=0; i<n; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (chs.containsKey(c1)) {
                if (chs.get(c1) != c2) {
                    return false;
                }
            } else {
                chs.put(c1, c2);
            }
            if (cht.containsKey(c2)) {
                if (cht.get(c2) != c1) {
                    return false;
                }
            } else {
                cht.put(c2, c1);
            }
        }

        return true;
        
    }
}

