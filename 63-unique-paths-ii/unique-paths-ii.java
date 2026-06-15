class Solution {
    public int uniquePathsWithObstacles(int[][] obstaclegrid) {
        int row = obstaclegrid.length;
        int col = obstaclegrid[0].length;

        int[][] dp = new int[row][col];

        if (obstaclegrid[0][0] == 1 || obstaclegrid[row-1][col-1] == 1) {
            return 0;
        }


        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if (obstaclegrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        int ans = dp[row-1][col-1];

        return ans;
    }
}