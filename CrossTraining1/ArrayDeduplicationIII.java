/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions : The given array is not null

Examples : {1, 2, 2, 3, 3, 3} → {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    /*
    slow pointer : [0, slow - 1] are elements to return
    fast pointer : current element to scan
    */
    int slow = 0;
    for(int fast = 0; fast < array.length; fast++){
      /*count number of adjacent duplicate elements*/
      int count = 0;
      while(fast + 1 < array.length && array[fast] == array[fast + 1]){
        count++;
        fast++;
      }
      /*
      fast is at the last index of this type of element
      copy if number of duplicate elements is 0
      */
      if(count == 0){
        array[slow++] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
//Time Complexity : O(n)   linear scan
//Space Complexity : O(1)
