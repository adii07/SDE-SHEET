/**Flatten Binary Tree to Linked List
Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

/**Solution 1: Iterative using Stack */
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> st=new Stack<>();
        TreeNode prev=null;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode head=st.pop();
            if(head.right!=null) st.push(head.right);
            if(head.left!=null) st.push(head.left);
            head.right=null;
            head.left=null;
            if(prev!=null){
                prev.right=head;
            }
            prev=head;
        }
    }
}
/**Solution 2: Recursion
Revese post order->Right,Left,root */
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}

/**Solution 3:PreOrder morris traversal
->Travel to the rightmost child of the left subtree
->Mark the right of the rightmost child as the right if the current node
->Update the right if the current node as the left of the current node(Make the left child the right child)
->Mark the left child as null.
->Move to the right child till node is not null
*/
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev=curr.left;
                while(prev.right!=null) prev=prev.right;
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}