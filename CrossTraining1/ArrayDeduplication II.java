/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions : The given array is not null

Examples : {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
*/

public class Solution {
  public int[] dedup(int[] array) {
    if(array.length <= 2){
      return array;
    }
    /*
    slow pointer : [0, slow - 1] are elements to return
    fast pointer : current index to scan
    */
    int slow = 2;
    for(int fast = 2; fast < array.length; fast++){
      /*
      copy when 2nd to last saved element is not the same as current element
      */
      if(array[slow - 2] != array[fast]){
        array[slow++] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
//Time Complexity : O(n) linear scan
//Space Complexity : O(1)
