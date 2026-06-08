public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int point = 0;
        int equal = 0;
        for (int i : nums) {
            if (i < pivot) {
                ans[point] = i;
                ++point;
            } else if (i == pivot) {
                ++equal;
            }
        }
        while (equal > 0) {
            ans[point] = pivot;
            ++point;
            --equal;
        }
        for (int i : nums) {
            if (i > pivot) {
                ans[point] = i;
                ++point;
            }
        }
        return ans;
    }
}
