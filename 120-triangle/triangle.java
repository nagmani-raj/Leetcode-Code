class Solution {

    private int solve(int row, int col,
                      List<List<Integer>> triangle,
                      int[][] dp) {

        int n = triangle.size();

        // Base case
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }

        int down = solve(row + 1, col, triangle, dp);
        int diagonal = solve(row + 1, col + 1, triangle, dp);

        return dp[row][col] =
                triangle.get(row).get(col)
                + Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, 0, triangle, dp);
    }
}