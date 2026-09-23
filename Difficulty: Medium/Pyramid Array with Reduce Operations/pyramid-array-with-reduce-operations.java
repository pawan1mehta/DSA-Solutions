class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        
        int totalSum = 0;
        for(int num : arr) {
            totalSum += num;
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1] + 1, arr[i]);
        }
        
        right[n - 1] = 1;
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1] + 1, arr[i]);
        }
        
        int minCost = totalSum;
        
        for(int i = 0; i < n; i++) {
            int peakHight = Math.min(left[i], right[i]);
            int cost = peakHight * peakHight;
            minCost = Math.min(minCost, totalSum - cost);
        }
        
        return minCost;
    }
};