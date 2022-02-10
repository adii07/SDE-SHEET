/**Allocate Minimum Number of Pages

Problem Statement: 
Given an array of integers A of size N and an integer B.
The College library has N bags, the ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

Conditions given :
A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example, A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return the minimum possible number. Return -1 if a valid assignment is not possible.

Example 1:
Input: A = [12, 34, 67, 90]
       B = 2

Output: 113
Explaination: Let’s see all possible cases of how books can be allocated for each student.
So, the maximum number of pages allocated in each case is [191,157,113]. So, the minimum number among them is 113. Hence, our result is 113.

Example 2:
Input: A = [5, 17, 100, 11]
       B = 4
Output: 100
 */


 /**Solution 1: Binary Search 
 
Approach :
->We will set a search space. 
->The lower boundary will be of minimal value among all the books given. 
->The upper boundary will be the sum of all book pages given. 
->Then apply binary search. 
->How to change the range of searching? 
    ->While searching, allocate pages to each student in such a way that the sum of allocated pages of each student is not greater than the mid-value of search space. 
    ->If allocating students increases more than the number of students provided, this shows that mid-value should be more, and hence, we move right by restricting our lower boundary as mid+1. 
    ->If an allocation is possible then reduce the search upper boundary by mid-1. 
    ->Also, an edge case to check while allocating, each book page should not be greater than mid-value chosen as a barrier.
*/

static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students) return true;
        return false;
    }
    public static int books(ArrayList < Integer > A, int B) {
        if (B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for (int i = 0; i < A.size(); i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            //cout << low << " " << high << " " << mid << endl; 
            if (isPossible(A, mid, B)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return res -> this is also correct
        return low;
    }