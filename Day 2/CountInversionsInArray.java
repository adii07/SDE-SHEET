/**
November 15, 2021 Arrays / Data Structure
Count inversions in an array
Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Explanation: we have a sorted array and the sorted array 
has 0 inversions as for i < j you will never find a pair 
such that A[j] < A[i]. More clear example: 2 has index 1 
and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an 
inversion.

Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Explanation: we have a reverse sorted array and we will 
get the maximum inversions as for i < j we will always 
find a pair such that A[j] < A[i]. 
Example: 5 has index 0 and 3 has index 2 now (5,3) pair 
is inversion as 0 < 2 and 5 > 3 which will satisfy out 
conditions and for reverse sorted array we will get 
maximum inversions and that is (n)*(n-1) / 2.
For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 8
Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),
(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and 
(1,4) as both are not satisfy our condition. 
*/



/**METHOD 1 (Brute force)

Approach: Traverse through the array, and for every index, find the number of smaller elements on its right side of the array. This can be done using a nested loop. Sum up the counts for all index in the array and print the sum.
Algorithm: 
Traverse through the array from start to end
For every element, find the count of elements smaller than the current number up to that index using another loop.
Sum up the count of inversion for every index.
Print the count of inversions.
 */

 /**METHOD 2(Enhance Merge Sort) 

Approach: 
Suppose the number of inversions in the left half and right half of the array (let be inv1 and inv2); what kinds of inversions are not accounted for in Inv1 + Inv2? 
The answer is – the inversions that need to be counted during the merge step. 
Therefore, to get the total number of inversions that needs to be added are the number of inversions in the left subarray, right subarray, and merge(). 

How to get the number of inversions in merge()? 
In merge process, let i is used for indexing left sub-array and j for right sub-array. 
At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]


Algorithm: 
->The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.
->Create a function merge that counts the number of inversions when two halves of the array are merged, 
    create two indices i and j, i is the index for the first half, and j is an index of the second half. 
    if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, 
    so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
->Create a recursive function to divide the array into halves and find the answer by summing the number of inversions is the first half, 
    the number of inversion in the second half and the number of inversions by merging the two.
->The base case of recursion is when there is only one element in the given half.
->Print the answer
*/
	// Function to count the number of inversions
	// during the merge process
	private static int mergeAndCount(int[] arr, int l,
									int m, int r)
	{

		// Left subarray
		int[] left = Arrays.copyOfRange(arr, l, m + 1);

		// Right subarray
		int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

		int i = 0, j = 0, k = l, swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else {
				arr[k++] = right[j++];
				swaps += (m + 1) - (l + i);
			}
		}
		while (i < left.length)
			arr[k++] = left[i++];
		while (j < right.length)
			arr[k++] = right[j++];
		return swaps;
	}

	// Merge sort function
	private static int mergeSortAndCount(int[] arr, int l,
										int r)
	{

		// Keeps track of the inversion count at a
		// particular node of the recursion tree
		int count = 0;

		if (l < r) {
			int m = (l + r) / 2;

			// Total inversion count = left subarray count
			// + right subarray count + merge count

			// Left subarray count
			count += mergeSortAndCount(arr, l, m);

			// Right subarray count
			count += mergeSortAndCount(arr, m + 1, r);

			// Merge count
			count += mergeAndCount(arr, l, m, r);
		}

		return count;
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] arr = { 1, 20, 6, 4, 5 };

		System.out.println(
			mergeSortAndCount(arr, 0, arr.length - 1));
	}
}

