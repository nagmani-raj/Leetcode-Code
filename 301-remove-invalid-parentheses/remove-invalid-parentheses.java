public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        boolean ri = false;
        dfs(s, 0, 0, res, ri);
        return res;
    }

    private void dfs(String s, int deletionSearch, int stackSearch, List<String> res, boolean ri) {
        int stack = 0;
        int p = stackSearch;
        while (p < s.length() && stack >= 0) {
            if (s.charAt(p) == ')') {
                stack--;
            }
            if (s.charAt(p) == '(') {
                stack++;
            }
            p++;
        }
        if (stack < 0) {
            String prefix = s.substring(0, p);
            for (int i = deletionSearch; i < prefix.length(); i++) {
                if (s.charAt(i) == ')' && (i == prefix.length() - 1 || s.charAt(i + 1) != ')')) {
                    
                    dfs(s.substring(0, i) + s.substring(i + 1), deletionSearch, p - 1, res, ri);
                   
                    deletionSearch = i + 1;
                }
            }
        } else {
            if (!ri) {
                s = reverseInvert(s);
                dfs(s, 0, 0, res, true);
            } else {
                s = reverseInvert(s);
                res.add(s);
            }
        }
    }

    private String reverseInvert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else if (c == ')') {
                sb.append('(');
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
