class Solution {
    private boolean canAliceWin(int n, int k, int turn) {
        if(n < k) {
            return turn == 0 ? false : true;
        }
        return canAliceWin(n - k, k - 1, turn == 0 ? 1: 0);
    }

    public boolean canAliceWin(int n) {
        return canAliceWin(n, 10, 0);
    }
}