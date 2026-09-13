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

    public int maxValue(int[][] events, int k) {
        int n = events.length;

        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int[][] dp = new int[k + 1][n + 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int count = 1; count <= k; count++) {
                int nextIdx = findNextIndx(events, events[i][1]);
                if(nextIdx != -1) {
                    dp[count][i] = Math.max(dp[count][i + 1], events[i][2] + dp[count - 1][nextIdx]);
                } else {
                    dp[count][i] = Math.max(events[i][2], dp[count][i + 1]);
                }
            }
        }

        return dp[k][0];
    }
}