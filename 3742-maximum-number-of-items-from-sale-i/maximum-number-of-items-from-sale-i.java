public class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        int[] free = new int[n];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int count = 0;
            for (int mult = f; mult <= maxFactor; mult += f) {
                count += freq[mult];
            }
            free[i] = count - 1;
        }
        int[] dp = new int[budget + 1];
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int weight = items[i][1];
            int value = 1 + free[i];
            for (int c = budget; c >= weight; c--) {
                if (dp[c - weight] != -1) {
                    dp[c] = Math.max(dp[c], dp[c - weight] + value);
                }
            }
        }
        int maxTotal = 0;
        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1) {
                int currentTotal = dp[c] + (budget - c) / minPrice;
                maxTotal = Math.max(maxTotal, currentTotal);
            }
        }
        return maxTotal;
    }
}
