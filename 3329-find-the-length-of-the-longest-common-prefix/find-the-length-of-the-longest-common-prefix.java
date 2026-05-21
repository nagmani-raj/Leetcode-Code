class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        java.util.HashSet<String> set = new java.util.HashSet<>();
        
        for (int num : arr1) {
            String s = String.valueOf(num);
            String prefix = "";
            
            for (char c : s.toCharArray()) {
                prefix += c;
                set.add(prefix);
            }
        }
        
        int ans = 0;
        
        for (int num : arr2) {
            String s = String.valueOf(num);
            String prefix = "";
            
            for (char c : s.toCharArray()) {
                prefix += c;
                
                if (set.contains(prefix)) {
                    ans = Math.max(ans, prefix.length());
                }
            }
        }
        
        return ans;
    }
}