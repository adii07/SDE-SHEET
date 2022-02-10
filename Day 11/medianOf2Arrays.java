/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. */


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(n<m) return findMedianSortedArrays(nums2,nums1);
        
        int low=0;
        int high=m,medianPos=((m+n)+1)/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int mid1=medianPos-mid;
            int upLeft=mid-1>=0?nums1[mid-1]:Integer.MIN_VALUE;
            int upRight=mid<m?nums1[mid]:Integer.MAX_VALUE;
            int lowLeft=mid1-1>=0?nums2[mid1-1]:Integer.MIN_VALUE;
            int lowRight=mid1<n?nums2[mid1]:Integer.MAX_VALUE;
            if(upLeft<=lowRight && upRight>=lowLeft){
                if((m+n)%2!=0) return (double)Math.max(upLeft,lowLeft);
                else return (double)(Math.max(upLeft,lowLeft)+Math.min(upRight,lowRight))/2.0;
            }
            if(upLeft>lowRight) high=mid-1;
            else low=mid+1;
        }
        
        return 0.0;
    }
}
/**
Approach :
->We will do a binary search in one of the arrays which have a minimum size among the two. 
->Firstly, calculate the median position with (n+1)/2. Point two-pointer, say low and high, equal to 0 and size of the array on which we are applying binary search respectively. 
->Find the partition of the array. Check if the left half has a total number of elements equal to the median position. 
->If not, get the remaining elements from the second array. Now, check if partitioning is valid. 
->This is only when l1<=r2 and l2<=r1. If valid, return max(l1,l2)(when odd number of elements present) else return (max(l1,l2)+min(r1,r2))/2.
->If partitioning is not valid, move ranges. When l1>r2, move left and perform the above operations again. When l2>r2, move right and perform the above operations. */