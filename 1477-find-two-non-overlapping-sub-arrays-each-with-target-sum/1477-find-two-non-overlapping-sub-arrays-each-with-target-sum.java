class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] prefLen = new int[n];
        int[] suffLen = new int[n];

        Map<Long, Integer> mp = new HashMap<>();

        mp.put(0L, -1);
        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(mp.containsKey(sum - target)) {
                prefLen[i] = Math.min(
                    i - mp.get(sum - target), 
                    i == 0 ? Integer.MAX_VALUE : prefLen[i - 1]
                );
            } else {
                prefLen[i] = i == 0 ? Integer.MAX_VALUE : prefLen[i - 1];
            }

            mp.put(sum, i);
        }

        mp.clear();
        mp.put(0L, n);
        sum = 0;

        for(int i = n - 1; i >= 0; i--) {
            sum += arr[i];

            if(mp.containsKey(sum - target)) {
                suffLen[i] = Math.min(
                    mp.get(sum - target) - i,
                    i == n - 1 ? Integer.MAX_VALUE : suffLen[i + 1]
                );
            } else {
                suffLen[i] = (i == n - 1 ? Integer.MAX_VALUE : suffLen[i + 1]);
            }

            mp.put(sum, i);
        }

        int minVal = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            if(prefLen[i - 1] != Integer.MAX_VALUE && suffLen[i] != Integer.MAX_VALUE) {
                minVal = Math.min(minVal, prefLen[i - 1] + suffLen[i]);
            }
        }
        
        return minVal == Integer.MAX_VALUE ? -1: minVal;
    }
}