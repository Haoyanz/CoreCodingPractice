/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

*/

/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
 
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    /*
    Step 1 : get depth of both target, let deeper node climb to the same level
    Step 2 : climb both node at the same time, if two nodes meet, then this node is LCA
    */
    if(one == null || two == null){
      return null;
    }
    int oneDepth = getDepth(one);
    int twoDepth = getDepth(two);
    TreeNodeP lower = oneDepth > twoDepth ? one : two;
    TreeNodeP higher = lower == one ? two : one;
    lower = climb(lower, Math.abs(oneDepth - twoDepth));
    while(lower != higher){
      lower = lower.parent;
      higher = higher.parent;
    }
    return lower;
  }
  private int getDepth(TreeNodeP node){
    int depth = 0;
    while(node.parent != null){
      depth++;
      node = node.parent;
    }
    return depth;
  }
  private TreeNodeP climb(TreeNodeP node, int n){
    for(int i = 0; i < n; i++){
      node = node.parent;
    }
    return node;
  }
}
//Time Complexity : O(height)
//Space Complexity : O(1)
