class Solution {
    public int robber(int[] nums,int ind , int[] dp) {
        if(ind >= nums.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        int take = nums[ind] + robber(nums , ind+2 , dp);
        int skip = robber(nums , ind+1 , dp);

        int ans = Math.max(take,skip);
        dp[ind] = ans;

        return ans;
        
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        return robber(nums,0, dp);
    }
}