/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root1);
        q2.add(root2);
        
        while(!q1.isEmpty() || !q2.isEmpty()) {
            Map<Integer, Integer> freq1 = new HashMap<>();
            
            int size = q1.size();
            while(size-- > 0) {
                Node node = q1.poll();
                
                freq1.put(node.data, freq1.getOrDefault(node.data, 0) + 1);
                
                if(node.left != null) {
                    q1.add(node.left);    
                }
                if(node.right != null) {
                    q1.add(node.right);
                }
            }
            
            size = q2.size();
            while(size-- > 0) {
                Node node = q2.poll();
                
                if(!freq1.containsKey(node.data)) {
                    return false;
                }
    
                freq1.put(node.data, freq1.get(node.data) - 1);
                if(freq1.get(node.data) == 0) {
                    freq1.remove(node.data);
                }
                
                if(node.left != null) {
                    q2.add(node.left);    
                }
                if(node.right != null) {
                    q2.add(node.right);
                }
            }
            
            if(freq1.size() != 0) {
                return false;
            }
        }
        
        return true;
    }
}
