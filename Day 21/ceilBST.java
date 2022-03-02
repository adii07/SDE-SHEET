/**Ceil from BST
Problem Statement
Ninja is given a binary search tree and an integer. Now he is given a particular key in the tree and returns its ceil value. Can you help Ninja solve the problem?

Note:
Ceil of an integer is the closest integer greater than or equal to a given number.

For example:
arr[] = {1, 2, 5, 7, 8, 9}, key = 3.
The closest integer greater than 3 in the given array is 5. So, its ceil value in the given array is 5.

Sample Input 1:
2
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
4
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
7
Sample Output 1:
5
7
*/

/**Solution:
->if you encunter a smaller value than X, move to the the right child as we want the smallest amongst the GREATER values.
->if a value greater than or equal to x in encounterd then mark it as a potential ans and move to left to find the smallest among the larger values */
public class Solution {
    public  static int findCeil(TreeNode<Integer> root, int x) {
        int ans=-1;
        while(root!=null){
            if(root.data<x){
                root=root.right;
            }
            else{
                ans=root.data;
                root=root.left;
            }
        }
        return ans;
    }
}
