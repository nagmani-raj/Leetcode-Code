class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        
        // dp[i][j][k]: max coins at (i,j) using k neutralizations
        int[][][] dp = new int[m][n][3];
        
        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        // Start cell (0,0)
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                if (k > 0) dp[0][0][k] = 0;  // neutralize
                else dp[0][0][k] = coins[0][0];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i == 0 && j == 0) continue;
                
                for (int k = 0; k < 3; k++) {
                    int val = coins[i][j];
                    
                    int bestPrev = Integer.MIN_VALUE;
                    
                    // From top
                    if (i > 0 && dp[i-1][j][k] != Integer.MIN_VALUE) {
                        bestPrev = Math.max(bestPrev, dp[i-1][j][k]);
                    }
                    
                    // From left
                    if (j > 0 && dp[i][j-1][k] != Integer.MIN_VALUE) {
                        bestPrev = Math.max(bestPrev, dp[i][j-1][k]);
                    }
                    
                    // Case 1: normal move
                    if (bestPrev != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + val);
                    }
                    
                    // Case 2: neutralize (only if negative)
                    if (val < 0 && k > 0) {
                        int bestPrevNeutral = Integer.MIN_VALUE;
                        
                        if (i > 0 && dp[i-1][j][k-1] != Integer.MIN_VALUE) {
                            bestPrevNeutral = Math.max(bestPrevNeutral, dp[i-1][j][k-1]);
                        }
                        
                        if (j > 0 && dp[i][j-1][k-1] != Integer.MIN_VALUE) {
                            bestPrevNeutral = Math.max(bestPrevNeutral, dp[i][j-1][k-1]);
                        }
                        
                        if (bestPrevNeutral != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrevNeutral);
                        }
                    }
                }
            }
        }
        
        return Math.max(dp[m-1][n-1][0],
               Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}