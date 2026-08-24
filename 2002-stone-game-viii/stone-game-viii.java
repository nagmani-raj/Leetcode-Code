public class Solution {
    public int stoneGameVIII(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            stones[i] = stones[i - 1] + stones[i];
        }
        int dp = stones[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            dp = Math.max(stones[i + 1] - dp, dp);
        }
        return dp;
    }
}