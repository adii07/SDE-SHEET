/**Kth largest/smallest element in Binary Search Tree
Problem statement: Given a binary search tree find the kth largest and smallest element in Binary Search Tree.

Examples:

Input: N=6
       Arr=[5,3,6,2,4,1]
       K=3
Output: Kth largest element is 4
        Kth smallest element is 3



Input: N=7
       Arr=[10,40,45,20,25,30,50]
       k=3
Output: Kth largest element is 4
        Kth smallest element is 3
*/
static Node insertBST(Node root,int val)
{
	if(root==null)
	{
		return new Node(val);
	}
	if(val<root.data)
	{
		root.left=insertBST(root.left,val);
	}
	else
	{
		root.right=insertBST(root.right,val);
	}
	return root;
}

static Node kthlargest(Node root,int k[])
{
	if(root==null)
	return null;
	
	Node right=kthlargest(root.right,k);
	if(right!=null)
	return right;
	k[0]--;
	
	if(k[0]==0)
	return root;
	
	return kthlargest(root.left,k);
}
        