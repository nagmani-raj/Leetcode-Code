class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        // Last row copy
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int row = n - 2; row >= 0; row--) {

            for (int col = 0;
                 col < triangle.get(row).size();
                 col++) {

                int down = dp[row + 1][col];
                int diagonal = dp[row + 1][col + 1];

                dp[row][col] =
                        triangle.get(row).get(col)
                        + Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}