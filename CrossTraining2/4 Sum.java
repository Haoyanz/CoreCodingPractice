/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false
*/

public class Solution {
  public boolean exist(int[] array, int target) {
    /*
    if there exists 4 sum, let 4 indices be a, b, c, d
    assume a < b < c < d
    sum1 = array[a] + array[b]
    sum2 = array[c] + array[d]
    put sum1 into HashMap and map to its (a, b)
    if there are multiple pairs of (a, b) of the same sum, keep smallest b
    */
    Map<Integer, Pair> map = new HashMap<>();
    for(int i = 1; i < array.length; i++){
      for(int j = 0; j < i; j++){
        Pair pair = map.get(target - array[i] - array[j]);
        if(pair != null && pair.right < j){
          return true;
        }
        if(!map.containsKey(array[i] + array[j])){
          map.put(array[i] + array[j], new Pair(j, i));
        }
      }
    }
    return false;
  }
  static class Pair{
    int left;
    int right;
    public Pair(int left, int right){
      this.left = left;
      this.right = right;
    }
  }
}
//Time Complexity : O(n ^ 2)
//Space Complexity : O(n ^ 2)
