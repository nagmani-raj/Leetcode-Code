class Solution {
    int[] dp;
    public int minCost(int[] cost , int index) {
        if(index<=1) return cost[index];
        if(dp[index]!=-1) return dp[index];
        return dp[index] = cost[index]+Math.min(minCost(cost , index-1),minCost(cost , index-2));

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];

        for(int i=0; i<=n; i++) dp[i] = -1;

        return Math.min(minCost(cost , n-1),minCost(cost , n-2));

    }
}


// class Solution {
//     int[] dp;

//     public int minCost(int[] cost, int index) {
//         if(index >= cost.length) return 0;

//         if(dp[index] != -1) return dp[index];

//         return dp[index] = cost[index] + Math.min(minCost(cost, index + 1), minCost(cost, index + 2));
//     }

//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         dp = new int[n + 1];

//         for(int i = 0; i <= n; i++) dp[i] = -1;

//         return Math.min(minCost(cost, 0), minCost(cost, 1));
//     }
// }
