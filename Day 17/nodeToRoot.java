/**Print Root to Node Path in a Binary Tree

Problem Statement: Print Root to Node Path In A Binary Tree. Write a program to print path from root to a given node in a binary tree.
Problem Description: We are given a binary tree T and a node V. We need to print a path from the root of the tree to the node.

Note:
    No two nodes in the tree have the same data value.
    It is assured that the node V is present and a path always exists. */


/**Solution 1: Recursion

->Add the node to the path
->if node is the required node return the path 
->call the function for the left and right child 
->if the right child or left child have the path return true and the path
-> if the required node os not present in any of the child of the node remove the node from the path
*/
    static boolean getPath(Node root, ArrayList < Integer > arr, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.data);

        // if it is the required node
        // return true
        if (root.data == x)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false   
        arr.remove(arr.size() - 1);
        return false;
    }
