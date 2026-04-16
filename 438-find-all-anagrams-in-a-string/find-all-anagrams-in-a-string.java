class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        int[] count = new int[26];
        for(char c:p.toCharArray()){
            count[c - 'a']++;
        }

        int right = 0 , left = 0 , needed = p.length();

        while(right < s.length()){
            char rchar= s.charAt(right);

            if(count[rchar - 'a'] > 0) {
                needed--;
            }

            count[rchar - 'a']--;
            right++;

            if(needed == 0){
                result.add(left);
            }

            if(right - left == p.length()){
                char lchar= s.charAt(left);

                if(count[lchar - 'a'] >= 0) {
                    needed++;
                }

                count[lchar - 'a']++;
                left++;
            }
        }

        return result;
    }
}