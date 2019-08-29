/*
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

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
  public int[] quickSort(int[] array) {
    if(array == null || array.length <= 1){
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }
  private void quickSort(int[] array, int left, int right){
    if(left >= right){
      return;
    }
    int pivotIndex = partition(array, left, right);
    quickSort(array, left, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, right);
  }
  private int partition(int[] array, int left, int right){
    int pivotIndex = left + (int)(Math.random() * (right - left + 1));
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);
    int l = left;
    int r = right - 1;
    while(l <= r){
      if(array[l] < pivot){
        l++;
      } else {
        swap(array, l, r);
        r--;
      }
    }
    swap(array, l, right);
    return l;
  }
  private void swap(int[] array, int l, int r){
    int temp = array[l];
    array[l] = array[r];
    array[r] = temp;
  }
}
//Time Complexity : O(n log n) in average, worst case O(n ^ 2)
//Space Complexity : O(log n) stacks, O(1) space on heap
