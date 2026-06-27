import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLength(int[] nums) {
        return withHashMap(nums);
    }

    private int withHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        if (map.containsKey(1)) {
            if (map.get(1) % 2 == 0) {
                ans = map.get(1) - 1;
            } else {
                ans = map.get(1);
            }
        }
        for (int key : map.keySet()) {
            if (key == 1) {
                continue;
            }
            int len = findSeries(map, key);
            ans = Math.max(ans, len);
        }
        return ans;
    }

    private int findSeries(Map<Integer, Integer> map, int key) {
        int sqr = key * key;
        if (map.containsKey(sqr)) {
            if (map.get(key) >= 2) {
                return 2 + findSeries(map, sqr);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
