/**Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
*/

/**Solution: 
Inorder traversal is a special traversal that helps us to identify a node and its left and right subtree. 
Preorder traversal always gives us the root node as the first element.
Using these properties we can construct the unique binary tree.

The algorithm approach can be stated as:
->Create a map to store the inorder indexes.
->Call the function constructTree with all 7 parameters as shown above.
->In the recursive function, first check the base case, if (preStart,>preEnd || inStart> inEnd) then return NULL.
->Construct a node (say root) with the root value( first element of preorder). 
->Find the index of the root, say elem from the hashmap.
->Find the number of elements ( say nElem) in the left subtree  = elem – inStart
->Call recursively for the left subtree with correct values (shown in the above table) and store the answer received in root->left.
->Call recursively for the right subtree with correct values (shown in the above table) and store the answer received in root->right.
->Return root
*/
class Main
{
 static TreeNode buildTree(int[] preorder, int[] inorder) {
    Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,inorder.length - 1, inMap);
    return root;
  }

  static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[]inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

    return root;
  }
  public static void main(String args[]) {

    int preorder[] = {10,20,40,50,30,60};
    int inorder[] = {40,20,50,10,60,30};
    TreeNode root = buildTree(preorder, inorder);
  }
}