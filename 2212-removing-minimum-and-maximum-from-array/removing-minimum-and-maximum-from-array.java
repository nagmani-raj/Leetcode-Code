public class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int firstCase;
        int secondCase;
        int thirdCase;
        if (minIndex > maxIndex) {
            firstCase = minIndex + 1;
            secondCase = n - maxIndex;
            thirdCase = maxIndex + 1 + (n - minIndex);
        } else {
            firstCase = maxIndex + 1;
            secondCase = n - minIndex;
            thirdCase = minIndex + 1 + (n - maxIndex);
        }
        return Math.min(firstCase, Math.min(secondCase, thirdCase));
    }
}
