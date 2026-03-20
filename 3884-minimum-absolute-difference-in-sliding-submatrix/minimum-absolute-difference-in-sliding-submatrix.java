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
        
        // Collect all elements in the k x k submatrix
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                elements.add(grid[i][j]);
            }
        }

        // Sort to find the minimum difference between adjacent values
        Collections.sort(elements);

        int minDiff = Integer.MAX_VALUE;
        boolean foundDistinct = false;

        for (int i = 1; i < elements.size(); i++) {
            int diff = Math.abs(elements.get(i) - elements.get(i - 1));
            
            // The problem asks for the difference between distinct values.
            // If the values are the same (diff == 0), we ignore them 
            // unless the entire matrix is the same value (handled by the Note).
            if (diff > 0) {
                minDiff = Math.min(minDiff, diff);
                foundDistinct = true;
            } else if (diff == 0) {
                // If there are duplicate values, the distance between 
                // those specific "distinct" values isn't 0, but the problem 
                // implies we look at the set of unique numbers.
                // However, the "Note" says if all are same, return 0.
            }
        }

        // If no distinct pairs were found (all elements are the same), return 0
        return foundDistinct ? minDiff : 0;
    }
}