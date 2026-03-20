import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int rows = m - k + 1;
        int cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = getMinDiff(grid, i, j, k);
            }
        }

        return ans;
    }

    private int getMinDiff(int[][] grid, int r, int c, int k) {
        List<Integer> elements = new ArrayList<>();
        
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                elements.add(grid[i][j]);
            }
        }

        
        Collections.sort(elements);

        int minDiff = Integer.MAX_VALUE;
        boolean foundDistinct = false;

        for (int i = 1; i < elements.size(); i++) {
            int diff = Math.abs(elements.get(i) - elements.get(i - 1));
            
           
            if (diff > 0) {
                minDiff = Math.min(minDiff, diff);
                foundDistinct = true;
            } else if (diff == 0) {
                
            }
        }

       
        return foundDistinct ? minDiff : 0;
    }
}