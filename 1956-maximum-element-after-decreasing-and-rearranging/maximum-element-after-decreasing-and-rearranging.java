public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] count = new int[arr.length + 1];
        for (int j : arr) {
            count[Math.min(j, arr.length)]++;
        }
        int ans = 1;
        for (int i = 1; i < count.length; i++) {
            ans = Math.min(i, ans + count[i]);
        }
        return ans;
    }
}