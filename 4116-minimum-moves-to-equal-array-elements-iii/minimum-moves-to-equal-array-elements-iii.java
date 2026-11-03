class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            sum += Math.abs(nums[n-1] - nums[i]);
        }

        return sum;
    }
}