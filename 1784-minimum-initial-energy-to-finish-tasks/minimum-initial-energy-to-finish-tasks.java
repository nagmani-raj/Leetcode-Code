public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        int prev = 0;
        for (int[] item : tasks) {
            prev = Math.max(prev + item[0], item[1]);
        }
        return prev;
    }
}