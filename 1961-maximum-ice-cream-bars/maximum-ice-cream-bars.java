class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int i , total = 0;

        Arrays.sort(costs);
        if(costs[0] > coins) return 0;

        for(i=0; i<n; i++){
            total += costs[i];
            if(total > coins) break;
        }

        return i;
    }
}