/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions : N > 0

Return
  A list of ways of putting the N Queens
  Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)

Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.

*/

public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> list = new ArrayList<>();
    int[] cur = new int[n];
    boolean[] usedCol = new boolean[n];
    boolean[] usedNeg = new boolean[2 * n - 1];
    boolean[] usedPos = new boolean[2 * n - 1];
    helper(0, n, cur, list, usedCol, usedNeg, usedPos);
    return list;
  }
  private void helper(int row, int n, int[] cur, List<List<Integer>> list, boolean[] usedCol, boolean[] usedNeg, boolean[] usedPos){
    //base case 
    if(row == n){
      list.add(toList(cur));
      return;
    }
    //recursive rule
    for(int i = 0; i < n; i++){
      if(valid(row, i, n, usedCol, usedNeg, usedPos)){
        mark(row, i, n, usedCol, usedNeg, usedPos);
        cur[row] = i;
        helper(row + 1, n, cur, list, usedCol, usedNeg, usedPos);
        unmark(row, i, n, usedCol, usedNeg, usedPos);
      }
    }
  }
  private boolean valid(int row, int col, int n, boolean[] usedCol, boolean[] usedNeg, boolean[] usedPos){
    return !usedCol[col] && !usedNeg[col + row] && !usedPos[col - row + n - 1];
  }
  private void mark(int row, int col, int n, boolean[] usedCol, boolean[] usedNeg, boolean[] usedPos){
    usedCol[col] = true;
    usedNeg[col + row] = true;
    usedPos[col - row + n - 1] = true;
  }
  private void unmark(int row, int col, int n, boolean[] usedCol, boolean[] usedNeg, boolean[] usedPos){
    usedCol[col] = false;
    usedNeg[col + row] = false;
    usedPos[col - row + n - 1] = false;
  }
  private List<Integer> toList(int[] array){
    List<Integer> list = new ArrayList<>();
    for(int i : array){
      list.add(i);
    }
    return list;
  }
}
//Time Complexity : O(n ^ n)
//Space Complexity : O(n)
