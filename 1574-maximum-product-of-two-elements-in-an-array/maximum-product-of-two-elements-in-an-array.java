class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int f = 0;
        int s = 1;
        if (nums[f] < nums[s]) {
            int temp = f;
            f = s;
            s = temp;
        }
        for(int i=2; i<n; i++){
            if(nums[f] <= nums[i]){
                s = f;
                f = i;
            }
            else if(nums[s] < nums[i]){
                s = i;
            }

        }
        int ans = (nums[f]-1)*(nums[s]-1);
        return ans;
    }
}