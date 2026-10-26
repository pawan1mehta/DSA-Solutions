class Solution {

    private int[] dr = new int[]{1, -1, 0, 0};
    private int[] dc = new int[]{0, 0, 1, -1};

    private long islandSum(int i, int j, int[][] grid) {
        if(!isValid(i, j, grid.length, grid[0].length) || grid[i][j] <= 0) {
            return 0;
        }

        long sum = grid[i][j];
        grid[i][j] = 0;

        for(int k = 0; k < 4; k++) {
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(isValid(ni, nj, grid.length, grid[0].length)) {
                sum += islandSum(ni, nj, grid);
            }
        }

        return sum;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) {
                    long sum = islandSum(i, j, grid);
                    if(sum%k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}