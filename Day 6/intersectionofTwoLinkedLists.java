/**Leetcode 160
Find intersection of Two Linked Lists
Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

Example 1:
Input:List 1 = [1,3,1,2,4], List 2 = [3,2,4]
Output:2 

Example 2:
Input:List1 = [1,2,7], List 2 = [2,8,1]
Output:Null
*/

/**Solution 1: for every node of list 1 check all the nodes of list 2 and return if simillar */

/**Solution 2:Use hashMap */

/**solution 3: size of the list
->find the size of the both the list 
->get their differnce
->move the larger list by the differnce
->now traverse both the list and return the point of intersection if present  */

/**Solution 4: Form a cycle
->traverse both the list
->when a list ends, move the node to the head of the other list
->repeat this untill both are same */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }
}