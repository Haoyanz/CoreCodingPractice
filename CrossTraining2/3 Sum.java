/*
Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter
Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
*/

public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(array);
    for(int i = 0; i < array.length - 2; i++){
      if(i > 0 && array[i] == array[i - 1]){
        continue;
      }
      int l = i + 1;
      int r = array.length - 1;
      while(l < r){
        if(array[i] + array[l] + array[r] == target){
          list.add(Arrays.asList(array[i], array[l], array[r]));
          l++;
          while(l < r && array[l] == array[l - 1]){
            l++;
          }
        } else if(array[i] + array[l] + array[r] < target){
          l++;
        } else {
          r--;
        }
      }
    }
    return list;
  }
}
//Time Complexity : O(n ^ 2)
//Space Complexity : O(1)
