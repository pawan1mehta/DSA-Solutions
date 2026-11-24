class Solution {

    public static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        
        if(b == 0) {
            return a;
        }
        
        if(a > b) {
            return gcd(a%b, b);
        }
        
        return gcd(a, b%a);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;

        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            int prod = 1;
            int gcd = 0;
            int lcm = 1;
            for(int j = i; j < n; j++) {
                prod = prod * nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm/gcd(lcm, nums[j]) * nums[j];
                if(prod == (lcm * gcd)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}