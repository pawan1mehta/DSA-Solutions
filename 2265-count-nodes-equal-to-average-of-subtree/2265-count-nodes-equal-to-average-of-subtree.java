/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int count;

    private long[] solve(TreeNode root) {
        if(root == null) {
            return new long[]{0, 0};
        }

        long[] leftSum = solve(root.left);
        long[] rightSum = solve(root.right);

        long sum = root.val + leftSum[0] + rightSum[0];
        long cnt = 1 + leftSum[1] + rightSum[1];

        if(sum/cnt == root.val) {
            count++;
        }

        return new long[]{sum, cnt};
    }

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        solve(root);
        return count;    
    }
}