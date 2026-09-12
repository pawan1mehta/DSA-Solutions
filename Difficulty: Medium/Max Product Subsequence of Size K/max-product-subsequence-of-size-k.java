class Solution {
    
    int[][] memoMax;
    int[][] memoMin;
    
    private int[] maxProductUtil(int i, int k, int[] arr) {
        if(k == 0) {
            return new int[]{1, 1};
        }
        
        if(i == arr.length) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};   
        }
        
        if(memoMax[i][k] != Integer.MIN_VALUE && memoMin[i][k] != Integer.MAX_VALUE) {
            return new int[]{memoMax[i][k], memoMin[i][k]};
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[] include = maxProductUtil(i + 1, k - 1, arr);
        
        if(include[0] != Integer.MIN_VALUE) {
            max = Math.max(max, arr[i] * include[0]);
            min = Math.min(min, arr[i] * include[0]);
        }
        if(include[1] != Integer.MAX_VALUE) {
            max = Math.max(max, arr[i] * include[1]);
            min = Math.min(min, arr[i] * include[1]);
        }
        
        int[] exclude = maxProductUtil(i + 1, k, arr);
        
        max = Math.max(max, exclude[0]);
        min = Math.min(min, exclude[1]);
        
        memoMax[i][k] = max;
        memoMin[i][k] = min;
        
        return new int[]{max, min};
    }
    
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        
        memoMax = new int[n][k + 1];
        memoMin = new int[n][k + 1];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(memoMax[i], Integer.MIN_VALUE);
            Arrays.fill(memoMin[i], Integer.MAX_VALUE);
        }
        
        int[] res = maxProductUtil(0, k, arr);
        
        return Math.max(res[0], res[1]);
    }
}