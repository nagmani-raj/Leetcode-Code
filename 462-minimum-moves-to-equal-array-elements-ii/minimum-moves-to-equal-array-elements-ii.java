public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = (nums.length - 1) / 2;
        int sum = 0;
        for (int num : nums) {
            if (num != nums[median]) {
                sum += Math.abs(nums[median] - num);
            }
        }
        return sum;
    }
}
