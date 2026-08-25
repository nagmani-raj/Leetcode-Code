class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int l = 0;

        for (int i = 1; i <= n + 1; i++) {  
            l = i * k;
            int f = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == l) {
                    f = 1;
                    break;
                }
            }

            if (f==0) {
                return l;
            }
        }

        return l;
    }
}
