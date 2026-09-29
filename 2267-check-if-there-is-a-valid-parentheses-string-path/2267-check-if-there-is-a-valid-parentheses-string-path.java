class Solution {
    private Boolean[][][] memo;

    private boolean solve(int i, int j, int count, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(!isValid(i, j, n, m)) {
            return false;
        }

        if(grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }

        if(count < 0) {
            return false;
        }

        if(i == n -1 && j == m - 1) {
            return count == 0 ? true : false;
        }

        if(memo[i][j][count] != null) {
            return memo[i][j][count];
        }

        return memo[i][j][count] = solve(i, j + 1, count, grid) || solve(i + 1, j, count, grid);
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        memo = new Boolean[n][m][1001];

        return solve(0, 0, 0, grid);
    }
}