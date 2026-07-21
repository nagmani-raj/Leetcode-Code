import java.util.*;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        List<Character> values = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();

        for (char c : t.toCharArray()) {
            if (values.isEmpty() || values.get(values.size() - 1) != c) {
                values.add(c);
                lengths.add(1);
            } else {
                int last = lengths.size() - 1;
                lengths.set(last, lengths.get(last) + 1);
            }
        }

        int gain = 0;

        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i) == '1'
                    && values.get(i - 1) == '0'
                    && values.get(i + 1) == '0') {

                gain = Math.max(gain,
                        lengths.get(i - 1) + lengths.get(i + 1));
            }
        }

        return ones + gain;
    }
}