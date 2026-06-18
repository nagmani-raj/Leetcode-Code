import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] isPal = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, isPal, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, String s, boolean[][] isPal,
                           List<String> path, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPal[start][end]) {
                path.add(s.substring(start, end + 1));

                backtrack(end + 1, s, isPal, path, result);

                path.remove(path.size() - 1);
            }
        }
    }
}