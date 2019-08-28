/*
Determine if there exist two elements in a given array, the sum of which is the given target number.

Assumptions

The given array is not null and has length of at least 2
​Examples

A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

A = {2, 4, 1}, target = 4, return false

*/

public class Solution {
  public boolean existSum(int[] array, int target) {
    // given array is not sorted, the length is at least 2.
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < array.length; i++){
      if(set.contains(target - array[i])){
        return true;
      }
      set.add(array[i]);
    }
    return false;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(n)
