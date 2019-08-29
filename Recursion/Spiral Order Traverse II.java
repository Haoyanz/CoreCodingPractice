/*
Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

  The 2D array is not null and has size of M * N where M, N >= 0

Examples

{ {1,  2,  3,  4},

  {5,  6,  7,  8},

  {9, 10, 11, 12} }

the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if(matrix.length == 0 || matrix[0].length == 0){
      return list;
    }
    helper(matrix, list, 0, matrix.length - 1, 0, matrix[0].length - 1);
    return list;
  }
  private void helper(int[][] matrix, List<Integer> list, int up, int down, int left, int right){
    //base case
    if(up > down || left > right){
      return;
    }
    if(up == down){
      for(int i = left; i <= right; i++){
        list.add(matrix[up][i]);
      }
      return;
    }
    if(left == right){
      for(int i = up; i <= down; i++){
        list.add(matrix[i][left]);
      }
      return;
    }
    //recursive rule
    for(int i = left; i <= right; i++){
      list.add(matrix[up][i]);
    }
    for(int i = up + 1; i <= down - 1; i++){
      list.add(matrix[i][right]);
    }
    for(int i = right; i >= left; i--){
      list.add(matrix[down][i]);
    }
    for(int i = down - 1; i >= up + 1; i--){
      list.add(matrix[i][left]);
    }
    helper(matrix, list, up + 1, down - 1, left + 1, right - 1);
  }
}
//Time Complexity : O(m * n)
//Space Complexity : O(min(m, n))
