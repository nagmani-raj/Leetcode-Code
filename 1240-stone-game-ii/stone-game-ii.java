class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n + 1];

        return dfs(0, 1, piles, suffixSum, dp);
    }

    private int dfs(int i, int M, int[] piles, int[] suffixSum, Integer[][] dp) {
        int n = piles.length;

        if (i >= n) return 0;

        if (2 * M >= n - i) {
            return suffixSum[i];
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int maxStones = 0;

        for (int x = 1; x <= 2 * M; x++) {
            maxStones = Math.max(
                maxStones,
                suffixSum[i] - dfs(i + x, Math.max(M, x), piles, suffixSum, dp)
            );
        }

        dp[i][M] = maxStones;
        return maxStones;
    }
}