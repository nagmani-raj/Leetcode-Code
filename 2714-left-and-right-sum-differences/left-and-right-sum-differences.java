class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int Sum = 0;
        for (int i = 0; i < n; i++) {
            Sum += nums[i];
        }

        int lSum = 0;

        for (int i = 0; i < n; i++) {
            Sum -= nums[i]; 
            ans[i] = Math.abs(lSum - Sum);
            lSum += nums[i];
        }

        return ans;
    }
}