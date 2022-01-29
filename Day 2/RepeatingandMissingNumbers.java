/**
Problem Statement: You are given a read-only array of N integers with values also in the range [1,N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing */

/**
Solution 1: Using Count Sort

Intuition + Approach: 

Since the numbers are from 1 to N in the array arr[]

Take a substitute array of size N+1 and initalize it with 0.
Traverse the given array and increase the value of substitute[arr[i]] by one .
Then again traverse the substitute array starting from index 1 to N.
 */

 /**Soltion 2
 (Use elements as Index and mark the visited places)
Approach: 
Traverse the array. 
While traversing, use the absolute value of every element as an index and make the value at this index as negative to mark it visited. 
If something is already marked negative then this is the repeating element. 
To find missing, traverse the array again and look for a positive value. */

	static void printTwoElements(int arr[], int size)
	{
		int i;
		System.out.print("The repeating element is ");

		for (i = 0; i < size; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				System.out.println(abs_val);
		}

		System.out.print("And the missing element is ");
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println(i + 1);
		}
	}

/**Soution 3
Use a hasSet or a hasmap or an int[] to act like map*/


/**Soution 4
Use bitmanipulation*/