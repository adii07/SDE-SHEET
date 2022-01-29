//Solution1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, here = m + n - 1;
        while(i1 >= 0 && i2 >= 0) {
            if(nums1[i1] >= nums2[i2]) {
                nums1[here--] = nums1[i1--];
            } else {
                nums1[here--] = nums2[i2--];
            }
        }
        while(i2 >= 0) {
            nums1[here--] = nums2[i2--];
        }
    }
}




// Solution2:
import java.util.*;
class TUF{
    static void swap(int a,int b)
    {
        int temp=a;
        a=b;
        b=temp;
    }
   static void merge(int ar1[], int ar2[], int n, int m) {
  int gap =(int) Math.ceil((double)(n + m) / 2.0);
  while (gap > 0) {
    int i = 0;
    int j = gap;
    while (j < (n + m)) {
      if (j < n && ar1[i] > ar1[j]) {
        swap(ar1[i], ar1[j]);
      } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
        swap(ar1[i], ar2[j - n]);
      } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
        swap(ar2[i - n], ar2[j - n]);
      }
      j++;
      i++;
    }
    if (gap == 1) {
      gap = 0;
    } else {
      gap =(int) Math.ceil((double) gap / 2.0);
    }
  }
}
public static void main(String[] args) {
    int arr1[] = {1,4,7,8,10};
	int arr2[] = {2,3,9};
    System.out.println("Before merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
    merge(arr1, arr2, arr1.length, arr2.length);
    System.out.println("After merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }

  }
}