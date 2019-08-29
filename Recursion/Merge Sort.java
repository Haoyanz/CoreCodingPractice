/*
Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

  {1} is sorted to {1}
  {1, 2, 3} is sorted to {1, 2, 3}
  {3, 2, 1} is sorted to {1, 2, 3}
  {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
  
Corner Cases

  What if the given array is null? In this case, we do not need to do anything.
  What if the given array is of length zero? In this case, we do not need to do anything.
*/

public class Solution {
  public int[] mergeSort(int[] array) {
    if(array == null || array.length <= 1){
      return array;
    }
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }
  private void mergeSort(int[] array, int[] helper, int left, int right){
    //base case
    if(left >= right){
      return;
    }
    //recursive rule
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }
  private void merge(int[] array, int[] helper, int left, int mid, int right){
    for(int i = left; i <= right; i++){
      helper[i] = array[i];
    }
    int l = left;
    int r = mid + 1;
    int cur = left;
    while(l <= mid && r <= right){
      if(helper[l] <= helper[r]){
        array[cur++] = helper[l++];
      } else {
        array[cur++] = helper[r++];
      }
    }
    while(l <= mid){
      array[cur++] = helper[l++];
    }
  }
}
