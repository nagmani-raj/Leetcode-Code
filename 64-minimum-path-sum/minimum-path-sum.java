class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {  
            int i = 0;

            dp[i][j] = dp[i][j-1] + grid[i][j];
        }
        for (int i = 1; i < m; i++) {
            int j = 0;
            dp[i][j] = dp[i-1][j] + grid[i][j];
        }

        for (int i = 1; i < m; i++) {      
            for (int j = 1; j < n; j++) {
                int a =  dp[i][j-1] + grid[i][j];
                int b =  dp[i-1][j] + grid[i][j];

                dp[i][j] = Math.min(a , b);
            }
        }

        int x = dp[m-1][n-1];

        return x;
    }
}