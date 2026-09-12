class Solution {
    private int findNextIndx(int[][] intervals, int endTime) {
        int n = intervals.length;

        int idx = -1;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(intervals[mid][0] > endTime) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int[][] dp = new int[n][2];

        dp[n - 1][0] = events[n - 1][2];
        dp[n - 1][1] = events[n - 1][2];

        for(int i = n - 2; i >= 0; i--) {
            int nextIdx = findNextIndx(events, events[i][1]);
            if(nextIdx != -1) {
                dp[i][1] = Math.max(dp[i + 1][1], events[i][2] + dp[nextIdx][0]);
                dp[i][0] = Math.max(events[i][2], dp[i + 1][0]);
            } else {
                dp[i][0] = Math.max(events[i][2], dp[i + 1][0]);
                dp[i][1] = Math.max(events[i][2], dp[i + 1][1]);
            }
        }

        return Math.max(dp[0][0], dp[0][1]);
    }
}