import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] count = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (count[rChar - 'a'] > 0) {
                needed--;
            }
            count[rChar - 'a']--;

            right++;

            if (needed == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                char lChar = s.charAt(left);

                if (count[lChar - 'a'] >= 0) {
                    needed++;
                }
                count[lChar - 'a']++;

                left++;
            }
        }

        return result;
    }
}