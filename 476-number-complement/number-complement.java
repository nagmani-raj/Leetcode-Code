class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        char[] arr = str.toCharArray(); 

        int sum = 0;
        int m = arr.length;

        for(int i = 0; i < m; i++){
            if(arr[i] == '0') arr[i] = '1';
            else arr[i] = '0';
        }

        for(int i = 0; i < m; i++){
            if(arr[i] == '1'){
                sum += (int)Math.pow(2, m-i-1);
            }
        }

        return sum;
    }
}