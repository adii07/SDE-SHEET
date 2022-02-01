/**leetcode 21. Merge Two Sorted Lists
 Problem Statement: Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and return them as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:

Input Format :
l1 = {3,7,10}, l2 = {1,2,5,8,10}
Output :
{1,2,3,5,7,8,10,10}


Example 2:
Input Format :
l1 = {}, l2 = {3,6}
Output :
{3,6}
*/

/**Solution 1: use an extra ll to store the sorted list
->Declare a dummy Node as head to store the sorted array node
->which ever node is smaller make the temp point to that and move to the next node.
Algo:
Step 1: Create two pointers, say l1 and l2. Compare the first node of both lists and find the small among the two. Assign pointer l1 to the smaller value node.
Step 2: Create a pointer, say res, to l1. An iteration is basically iterating through both lists till the value pointed by l1 is less than or equal to the value pointed by l2.
Step 3: Start iteration. Create a variable, say, temp. It will keep track of the last node sorted list in an iteration. 
Step 4: Once an iteration is complete, link node pointed by temp to node pointed by l2. Swap l1 and l2.
Step 5: If any one of the pointers among l1 and l2 is NULL, then move the node pointed by temp to the next higher value node.*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode();
        ListNode temp=head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next=list1==null?list2:list1;
        return head.next;       
    }
}

/**Solution 2: Without using extra space
->Declare a head to store the starting point of the ans
->if list1 is greater than list 2 val swap the list
->make head equal to the smaller head(list1 always as we swap)
4->now tarverse till list1 val are smaller than the list 2 val
->if list 2 val is greater then break the loop,and make the last visited node point to the list2 node
->again swap list1 and list2 so that list1 is the smallest and repeat step 4 till both are empty */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val>list2.val){
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        ListNode head=list1;
        while(list1!=null && list2!=null){
            ListNode prev=null;
            while(list1!=null && list1.val<=list2.val){
                prev=list1;
                list1=list1.next;
            }
            prev.next=list2;
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        return head;
        
    }
}