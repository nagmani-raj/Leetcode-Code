class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);

        s = s.replace("0","");

        if(s.length() == 0) return 0L;
        long ans = Long.parseLong(s);

        int sum = 0;
        while(n>0){
            int r = n%10;
            sum += r;
            n = n/10;
        }

        return ans*sum;
    }
}