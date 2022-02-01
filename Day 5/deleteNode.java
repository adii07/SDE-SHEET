/**237. Delete Node in a Linked List
-Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
-It is guaranteed that the node to be deleted is not a tail node in the list.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function. */


/**Solution 1: Optimal
->Update the value of the current node with the value if the nextNode
->Update the next pointer of the current node to point to the next node's nextPointer. */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

/**Solution 2: Brute force
->we can obly operate the right side of the node as that is only given to us
->therefore we copy the value of the next node to the current node till we reach the last node.
-> once we reach the last node we mark it as null.
*/