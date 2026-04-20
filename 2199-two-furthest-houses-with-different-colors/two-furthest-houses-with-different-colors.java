class Solution {
    public int maxDistance(int[] colors) {
        int col = colors.length;
        int maxind = 0;
        int val = colors[0];

        for(int i=1; i<col; i++){
            if(val != colors[i]){
                maxind = Math.max(maxind , i);
            }
        }

        for(int i = col-1; i >= 0; i--){
            if(colors[i] != colors[col-1]){
                maxind = Math.max(maxind, col-1 - i);
            }
        }

        return maxind; 
    }
}