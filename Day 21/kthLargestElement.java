/**Kth largest element in Binary Search Tree */
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