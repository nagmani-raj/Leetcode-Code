public class Solution {
    private String word;
    private Integer[][][] dp;

    public int minimumDistance(String word) {
        this.word = word;
        dp = new Integer[27][27][word.length()];
        return find(null, null, 0);
    }

    private int find(Character f1, Character f2, int index) {
        if (index == word.length()) {
            return 0;
        }

        Integer result = dp[f1 == null ? 0 : f1 - 'A' + 1][f2 == null ? 0 : f2 - 'A' + 1][index];
        if (result != null) {
            return result;
        }

        char ic = word.charAt(index);

        int move = move(f1, ic) + find(ic, f2, index + 1);

        move = Math.min(move, move(f2, ic) + find(f1, ic, index + 1));

        dp[f1 == null ? 0 : f1 - 'A' + 1][f2 == null ? 0 : f2 - 'A' + 1][index] = move;
        return move;
    }

    private int move(Character c1, Character c2) {
        if (c1 == null) {
            return 0;
        }

        int c1x = (c1 - 'A') % 6;
        int c1y = (c1 - 'A') / 6;
        int c2x = (c2 - 'A') % 6;
        int c2y = (c2 - 'A') / 6;

        return Math.abs(c1x - c2x) + Math.abs(c1y - c2y);
    }
}
