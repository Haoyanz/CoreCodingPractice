/*
Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5

      /   \

     2     12

   /  \      \

  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2

*/

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

public class Solution {
  public TreeNode lca(TreeNode root, int p, int q) {
    /*
    base case : return root if root is null or found target

    recursive rule : if both target value are less than current value, then find lca from left subtree
                     if both target value are greater than current value, then find lca from right subtree
                     if one value is smaller and the other one larger, then return current node
    */
    if(root == null || root.key == p || root.key == q){
      return root;
    }
    if(root.key > p && root.key > q){
      return lca(root.left, p, q);
    }
    if(root.key < p && root.key < q){
      return lca(root.right, p, q);
    }
    return root;
  }
}
//Time Complexity : O(log n)
//Space Complexity : O(height)

