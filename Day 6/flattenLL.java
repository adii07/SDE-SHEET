/**You are given a linked list containing N nodes, where every node in the linked list contains two pointers, first one is ‘NEXT’ which points to the next node in the list and the second one is ‘CHILD’ pointer to a linked list where the head is this node. And each of these child linked lists is in sorted order.
Your task is to flatten this linked such that all nodes appear in a single layer or level while the nodes should maintain the sorted order.
 */
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
    public static Node mergeTwoLists(Node a, Node b) {
        
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.child = a; 
                temp = temp.child; 
                a = a.child; 
            }
            else {
                temp.child = b;
                temp = temp.child; 
                b = b.child; 
            }
        }
        
        if(a != null) temp.child = a; 
        else temp.child = b;
        return res.child; 
    
    }
    public static Node flattenLinkedList(Node root)
    {
       
            if (root == null || root.next == null) 
                return root; 
      
            // recur for list on right 
            root.next = flattenLinkedList(root.next); 
      
            // now merge 
            root = mergeTwoLists(root, root.next); 
      
            // return the root 
            // it will be in turn merged with its left 
            return root; 
    }
}

