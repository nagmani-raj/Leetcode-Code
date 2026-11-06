class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int m = arr1.length;
        int n = arr2.length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int p = Math.abs(arr1[i] - arr2[j]);
                if(p>d){
                    if(j == n-1){
                        count++;
                    }
                }else{
                    break;
                }
            }
        }

        return count;
    }
}