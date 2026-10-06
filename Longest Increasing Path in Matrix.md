## 01. Longest Increasing Path in Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1)

### Problem Description

**Task:** Given a matrix with n rows and m columns. Your task is to find the length of the longest path in with the following constraints
The values in path strictly increasing. For example if a path of length k has values a_1, a_2, a_3, .... a_k , then for every i from [2, k] this condition must hold a_i > a_i-1.
No cell should be revisited in the path.
From each cell, you can move in any of of the four directions: left, right, up, or down.
You are not allowed to move diagonally or move outside the boundary.

#### Examples

##### Example 1

- **Input:**
```text
n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```
- **Output:**
```text
5
```
- **Explanation:** One such path is 1 - > 2 - > 3 - > 6 - > 9, where each number is strictly greater than the previous.

##### Example 2

- **Input:**
```text
n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
```
- **Output:**
```text
4
```
- **Explanation:** One of the longest increasing paths is 3 - > 4 - > 5 - > 6.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(n * m)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-10-06 11:00:09
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    
    private int[] dr = new int[]{1, -1, 0, 0};
    private int[] dc = new int[]{0, 0, 1, -1};
    
    private int[][] memo;
    
    private int solve(int r, int c, int[][] matrix) {
        if(memo[r][c] != -1) {
            return memo[r][c];
        }

        int maxLen = 0;

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(isValid(nr, nc, matrix.length, matrix[0].length)
                && matrix[nr][nc] > matrix[r][c]) {
                maxLen = Math.max(maxLen, solve(nr, nc, matrix));
            }
        }
        
        return memo[r][c] = 1 + maxLen;
    }
    
    private boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
    
    public int longIncPath(int[][] matrix, int n, int m) {
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, solve(i, j, matrix));
            }
        }
        
        return maxLen;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-10-06 10:59:23
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    
    private int[] dr = new int[]{1, -1, 0, 0};
    private int[] dc = new int[]{0, 0, 1, -1};
    
    private int[][] memo;
    
    private int solve(int r, int c, int[][] matrix) {
        if(memo[r][c] != -1) {
            return memo[r][c];
        }

        int maxLen = 0;

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(isValid(nr, nc, matrix.length, matrix[0].length)
                && matrix[nr][nc] > matrix[r][c]) {
                maxLen = Math.max(maxLen, solve(nr, nc, matrix));
            }
        }
        
        return memo[r][c] = 1 + maxLen;
    }
    
    private boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
    
    public int longIncPath(int[][] matrix, int n, int m) {
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, solve(i, j, matrix));
            }
        }
        
        return maxLen;
    }
}
```

*Generated on: 06/10/2026, 11:12:31*