/**Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

/*Solution :Using BFS(queue)->Reverse Level order traversal
->Start the level order traversal
->Mark a prev node at the start of the level order traversal
->First add the right child and then the left child to maintain the structure of the question
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node prev=null;
            int size=q.size();
            while(size-->0){
                Node head=q.remove();
                head.next=prev;
                prev=head;
                if(head.right!=null)q.add(head.right);
                if(head.left!=null)q.add(head.left);
            }
        }
        return root;
    }
}