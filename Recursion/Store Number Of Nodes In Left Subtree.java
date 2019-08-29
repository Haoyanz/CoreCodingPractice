/*
Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.

Examples

 

                  1(6)

               /          \

           2(3)           3(0)

          /      \

      4(1)       5(0)

    /       \         \

6(0)        7(0)       8(0)

The numNodesLeft is shown in parentheses.
*/

/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    countNum(root);
  }
  private int countNum(TreeNodeLeft root){
    if(root == null){
      return 0;
    }
    int left = countNum(root.left);
    int right = countNum(root.right);
    root.numNodesLeft = left;
    return left + right + 1;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(height)
