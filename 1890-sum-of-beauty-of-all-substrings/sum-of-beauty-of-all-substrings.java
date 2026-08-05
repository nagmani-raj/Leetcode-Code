class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            for(int j = i; j<n; j++){
                freq[s.charAt(j) - 'a']++;
                int maxf = 0;
                int minf = 1000000;

                for(int f : freq){
                    if(f > 0){
                        maxf = Math.max(maxf,f);
                        minf = Math.min(minf,f);
                    }
                }

                ans += (maxf - minf);
            }
        }

        return ans;
    }
}