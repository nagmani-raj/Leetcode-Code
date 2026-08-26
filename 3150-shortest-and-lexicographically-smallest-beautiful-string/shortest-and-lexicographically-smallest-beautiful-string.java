class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

        String ans = "";

        for (int i = 0; i + k - 1 < ones.size(); i++) {
            int left = ones.get(i);
            int right = ones.get(i + k - 1);

            String cur = s.substring(left, right + 1);

            if (ans.isEmpty()
                    || cur.length() < ans.length()
                    || (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {
                ans = cur;
            }
        }

        return ans;
    }
}