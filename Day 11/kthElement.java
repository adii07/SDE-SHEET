/**K-th Element of two sorted arrays
Problem Statement: Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.

Examples :

Input: m = 5
       n = 4
       array1 = [2,3,6,7,9]
       array2 = [1,4,8,10]
       k = 5

Output:
 6

Explanation: Merging both arrays and sorted. Final array will be -
 [1,2,3,4,6,7,8,9,10]
We can see at k = 5 in the final array has 6. 


Input:
 m = 1
       n = 4
       array1 = [0]
       array2 = [1,4,8,10]
       k = 2

Output:
 4
Explanation:
 Merging both arrays and sorted. Final array will be -
 [1,4,8,10]
We can see at k = 2 in the final array has 4 */

/**
*We can part it in such a way that our kth element will be at the end of the left half array. 
->Let’s make some observations. 
*The left portion of the array is made of some elements of both array1 and array2. 
*We can see that all elements of the right half of the array are always larger than the left ones. 
*So, with help of binary search, we will divide arrays into partitions with keeping k elements in the left half. 
*We have to keep in mind that l1 <= r2 and l2 <= r1. Why so? This ensures that left-half elements are always lesser than right elements.
*/

 static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
    if(m > n) {
        return kthelement(arr2, arr1, n, m, k); 
    }
        
    int low = Math.max(0,k-m), high = Math.min(k,n);
        
    while(low <= high) {
        int cut1 = (low + high) >> 1; 
        int cut2 = k - cut1; 
        int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
        int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
        int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
        int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 
            
        if(l1 <= r2 && l2 <= r1) {
            return Math.max(l1, l2);
        }
        else if (l1 > r2) {
            high = cut1 - 1;
        }
        else {
            low = cut1 + 1; 
        }
    }
    return -1;
    }

/**
Approach :
->Start iterating with two pointers, say left and right. 
->Find the middle of the range. 
->Take elements from low to middle of array1 and the remaining elements from the second array. 
->Then using the condition mentioned above, check if the left half is valid. If valid, print the maximum of both array’s last element. 
->If not, move the range towards the right if l2 > r1, else move the range towards the left if l1 > r2.
Time Complexity : log(min(m,n))
*/   