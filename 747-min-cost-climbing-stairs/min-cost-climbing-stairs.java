class Solution {
    public int minCost(int[] cost , int ind , int[] dp) {
        if(ind >= cost.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        int ans = cost[ind] + Math.min(minCost(cost, ind+1, dp) ,minCost(cost, ind+2, dp));
        dp[ind] = ans;
        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost, 0, dp) ,minCost(cost, 1, dp));
    }
}