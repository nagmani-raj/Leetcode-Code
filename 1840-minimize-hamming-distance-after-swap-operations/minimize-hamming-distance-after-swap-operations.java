import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb)
                parent[pa] = pb;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        DSU dsu = new DSU(n);

        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        for (List<Integer> group : groups.values()) {

            Map<Integer, Integer> freq = new HashMap<>();

            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    result++; // mismatch
                }
            }
        }

        return result;
    }
}