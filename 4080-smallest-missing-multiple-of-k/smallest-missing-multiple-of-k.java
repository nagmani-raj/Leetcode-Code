class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);

        int l = k;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == l) {
                l += k;
            }
        }

        return l;
    }
}