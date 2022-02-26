/**Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1] 
*/

/**Solution 1: Recursion */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        while(true){
            while (root != null){
                ans.add(root.val);
                q.push(root);
                root  = root.left;
		    }
            if (q.isEmpty()) break;
            root = q.pop();
            root = root.right;
        }
        return ans;
        

        
    }
}