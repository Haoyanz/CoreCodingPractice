/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions : The given array is not null

Examples : {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    if(array.length <= 1){
      return array;
    }
    /*
    slow : [0, slow - 1] are elements to return
    fast : current element to scan
    */
    int slow = 1;
    for(int fast = 1; fast < array.length; fast++){
      /*
      when there are adjacent duplicate elements, move slow to the left and fast to the right until next type of element
      */
      if(slow == 0 || array[slow - 1] != array[fast]){
        array[slow++] = array[fast];
      } else {
        slow--;
        while(fast + 1 < array.length && array[fast] == array[fast + 1]){
          fast++;
        }
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
