/*
Given an array of integers, move all the 0s to the right end of the array.

  The relative order of the elements in the original array does not need to be maintained.

Assumptions:

  The given array is not null.

Examples:

  {1} --> {1}
  {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
*/

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    int slow = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] != 0){
        array[slow++] = array[i];
      }
    }
    for(int i = slow; i < array.length; i++){
      array[i] = 0;
    }
    return array;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
