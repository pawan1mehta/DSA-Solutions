class Solution {
    int[][] memo;
    
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

    private int solve(int i, int k, int[][] events) {
        if(k == 0 || i >= events.length || i < 0) {
            return 0;
        }

        if(memo[i][k] != -1) {
            return memo[i][k];
        }
 
        int j = findNextIndx(events, events[i][1]);

        int opt1 = events[i][2] + solve(j, k - 1, events);
        int opt2 = solve(i + 1, k, events);

        return memo[i][k] = Math.max(opt1, opt2);
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

        memo = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(0, k, events);
    }
}