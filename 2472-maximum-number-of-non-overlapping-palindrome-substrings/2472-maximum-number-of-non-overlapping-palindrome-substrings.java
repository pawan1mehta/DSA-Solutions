class Solution {

    private int[] isPalindrom(StringBuilder s, int lastIdx, int idx1, int idx2, int k) {
        int n = s.length();

        int i = idx1;
        int j = idx2;

        int len = 0;

        while(lastIdx <= i && j < n) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }

            if(i == j) {
                len += 1;
            } else {
                len += 2;
            }

            if(len >= k) {
                return new int[]{1, j + 1};
            }

            i--;
            j++;
        }

        return new int[]{0, -1};
    }

    int[][] memo;

    private int solve(int idx, int lastIdx, StringBuilder s, int k) {
        if(idx >= s.length() || lastIdx >= s.length()) {
            return 0;
        }

        if(memo[idx][lastIdx] != -1) {
            return memo[idx][lastIdx];
        }

        int maxCount = 0;

        for(int i = idx; i < s.length(); i++) {
            int[] res = isPalindrom(s, lastIdx, i, i, k);

            if(res[0] == 1) {
                maxCount = Math.max(maxCount, 1 + solve(res[1], res[1], s, k)); 
            } 

            res = isPalindrom(s, lastIdx, i - 1, i, k);

            if(res[0] == 1){
                maxCount = Math.max(maxCount, 1 + solve(res[1], res[1], s, k)); 
            }
        }

        return memo[idx][lastIdx] = maxCount;
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();

        memo = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(0, 0, new StringBuilder(s), k);
    }
}