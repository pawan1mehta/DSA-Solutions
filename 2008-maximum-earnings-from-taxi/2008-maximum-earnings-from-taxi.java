class Solution {

    private int findNextIndx(int[][] intervals, int endTime) {
        int n = intervals.length;

        int idx = -1;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(intervals[mid][0] >= endTime) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    public long maxTaxiEarnings(int m, int[][] rides) {
        int n = rides.length;

        Arrays.sort(rides, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        long[] dp = new long[n];

        dp[n - 1] = val(rides[n - 1]);
        for(int i = n - 2; i >= 0; i--) {
            long val = val(rides[i]);

            int nextIdx = findNextIndx(rides, rides[i][1]);
            if(nextIdx != -1) {
                dp[i] = Math.max(val + dp[nextIdx], dp[i + 1]);
            } else {
                dp[i] = Math.max(val, dp[i + 1]);
            }
        }

        return dp[0];
    }

    private long val(int[] interval) {
        return (interval[1] - interval[0]) + interval[2];
    }
}