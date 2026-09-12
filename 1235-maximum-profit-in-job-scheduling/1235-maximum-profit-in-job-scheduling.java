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

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] intervals = new int[n][3];

        for(int i = 0; i < n; i++) {
            intervals[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] dp = new int[n];

        dp[n - 1] = intervals[n - 1][2];
        for(int i = n - 2; i >= 0; i--) {
            int nextIdx = findNextIndx(intervals, intervals[i][1]);
            if(nextIdx != -1) {
                dp[i] = Math.max(dp[i + 1], intervals[i][2] + dp[nextIdx]);
            } else {
                dp[i] = Math.max(dp[i + 1], intervals[i][2]);
            }
        }

        return dp[0];
    }
}