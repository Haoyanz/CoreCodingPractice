/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N * N where N >= 0
Examples

{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if(matrix.length == 0){
      return list;
    }
    helper(matrix, list, 0, matrix.length);
    return list;
  }
  private void helper(int[][] matrix, List<Integer> list, int offset, int size){
    //base case
    if(size == 0){
      return;
    }
    if(size == 1){
      list.add(matrix[offset][offset]);
      return;
    }
    //recursive rule
    for(int i = 0; i < size - 1; i++){
      list.add(matrix[offset][offset + i]);
    }
    for(int i = 0; i < size - 1; i++){
      list.add(matrix[offset + i][offset + size - 1]);
    }
    for(int i = size - 1; i > 0; i--){
      list.add(matrix[offset + size - 1][offset + i]);
    }
    for(int i = size - 1; i > 0; i--){
      list.add(matrix[offset + i][offset]);
    }
    helper(matrix, list, offset + 1, size - 2);
  }
}
//Time Complexity : O(n ^ n)
//Space Complexity : O(n)
