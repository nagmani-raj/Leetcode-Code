class Solution {
    public int amount(int[] nums , int ind,int end, int[] dp) {
        if(ind > end) return 0;

        if(dp[ind] != -1) return dp[ind];

        int take = nums[ind] + amount(nums , ind+2, end, dp);
        int skip = amount(nums , ind+1, end, dp);
        int ans = Math.max(take, skip);
        dp[ind] = ans;

        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);

        int case1 = amount(nums , 0 , n-2, dp1);
        int case2 = amount(nums , 1 , n-1, dp2);

        return Math.max(case1, case2);
    }
}

