public class Solution {
    public boolean sumGame(String num) {
        int count = 0;
        int diff = 0;
        int l = num.length();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                count += i < l / 2 ? 1 : -1;
            } else {
                if (i < l / 2) {
                    diff += num.charAt(i) - '0';
                } else {
                    diff -= num.charAt(i) - '0';
                }
            }
        }
        return diff * 2 != -9 * count;
    }
}