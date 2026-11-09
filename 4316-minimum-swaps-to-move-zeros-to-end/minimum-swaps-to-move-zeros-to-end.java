class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int count = 0;
        
        while(i<=j){
            if(nums[i] == 0 && nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                count++;

                i++;
                j--;
            }

            else if(nums[i] != 0){
                i++;
            }
            else if(nums[j] == 0){
                j--;
            }
        }

        return count;
    }
}