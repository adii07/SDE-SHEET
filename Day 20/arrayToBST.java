/**Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
*/

/**Solution 1:Recursion 
->The mid point of the array is the root element at each recusrive call, this is because all the elements to the left are smaller and all the elements to the right are larger in value than the mid value
->Therefore make the mid the root and call recusrion for the left and the right child
->From start to mid is the left subtree
->From mid+1 to end is the right subtree
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length==0)return null;
            int ptr=nums.length/2;
            TreeNode root=new TreeNode(nums[ptr]);
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,ptr));
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums,ptr+1,nums.length));
            return root;
    }
}