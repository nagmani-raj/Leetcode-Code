class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, sum = 0, ans = 0;
        int prefixZeros = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left < right && (sum > goal || nums[left] == 0)) {
                if (nums[left] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros++;
                }
                sum -= nums[left];
                left++;
            }

            if (sum == goal) {
                ans += 1 + prefixZeros;
            }
        }

        return ans;
    }
}