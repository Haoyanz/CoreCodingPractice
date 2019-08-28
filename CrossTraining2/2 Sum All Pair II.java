/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

Assumptions

The given array is not null and has length of at least 2
The order of the values in the pair does not matter
Examples

A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
*/

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> list = new ArrayList<>();
    //map an integer value to whether it has been used
    Map<Integer, Boolean> map = new HashMap<>();
    for(int i = 0; i < array.length; i++){
      Boolean used = map.get(target - array[i]);
      if(used != null && used == false){
        list.add(Arrays.asList(target - array[i], array[i]));
        map.put(array[i], true);
        map.put(target - array[i], true);
      }
      if(!map.containsKey(array[i])){
        map.put(array[i], false);
      }
    }
    return list;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(n)
