public class Solution {
    public int minInsertions(String s) {
        int conClosed = 0;
        int opened = 0;
        int total = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                conClosed++;
                if (conClosed == 2) {
                    conClosed = 0;
                    if (opened > 0) {
                        opened--;
                    } else {
                        total++;
                    }
                }
            } else {
                if (conClosed == 1) {
                    if (opened > 0) {
                        opened--;
                        total += 1;
                    } else {
                        total += 2;
                    }
                    conClosed = 0;
                }
                opened += 1;
            }
        }
        if (conClosed == 1) {
            if (opened > 0) {
                opened--;
                total += 1;
            } else {
                total += 2;
            }
        }
        total += opened * 2;
        return total;
    }
}