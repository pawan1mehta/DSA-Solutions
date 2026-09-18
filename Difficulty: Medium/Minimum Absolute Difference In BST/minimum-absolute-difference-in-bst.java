/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    private void solve(Node root, ArrayList<Integer> nodes) {
        if(root == null) {
            return;
        }    
        solve(root.left, nodes);
        nodes.add(root.data);
        solve(root.right, nodes);
    }
    
    public int absDiff(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        
        solve(root, nodes);
        
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i = 1; i < nodes.size(); i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(nodes.get(i - 1) - nodes.get(i)));
        }
        
        return minAbsDiff;
    }
}
