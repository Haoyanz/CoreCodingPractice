/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions : The array is not null

Examples : {1, 2, 2, 3, 3, 3} → {1, 2, 3}
*/

public class Solution {
  public int[] dedup(int[] array) {
    //when array length is 0 or 1, return input array directly
    if(array.length <= 1){
      return array;
    }
    //slow pointer : [0, slow - 1] are elements to be saved
    //fast pointer : current index to check
    int slow = 1;
    for(int fast = 1; fast < array.length; fast++){
      //when current element is not the same as last element copied, add this element
      if(array[fast] != array[slow - 1]){
        array[slow++] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
//Time Complexity : O(n) linear scan
//Space Complexity : O(1)
