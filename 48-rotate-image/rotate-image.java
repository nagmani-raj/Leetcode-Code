class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }

        
    }
    public void reverse(int[] arr){
        int n = arr.length;
        
        for(int j=0 ; j<n/2 ; j++){
            int temp = arr[j];
            arr[j] = arr[n-j-1];
            arr[n-j-1] = temp;
        }
    }
}