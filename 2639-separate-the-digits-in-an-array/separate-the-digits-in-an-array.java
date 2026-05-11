public class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder str = new StringBuilder();
        for (int num : nums) {
            str.append(num);
        }
        int[] ar = new int[str.length()];
        String s = str.toString();
        for (int i = 0; i < s.length(); i++) {
            ar[i] = s.charAt(i) - '0';
        }
        return ar;
    }
}
