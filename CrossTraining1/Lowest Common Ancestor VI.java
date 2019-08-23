/*
Given M nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

- M >= 2.

- There is no parent pointer for the nodes in the K-nary tree.

- The given M nodes are guaranteed to be in the K-nary tree.

Examples

        5

      /   \

     9   12

   / | \      \

  1 2 3     14



The lowest common ancestor of 2, 3, 14 is 5.

The lowest common ancestor of 2, 3, 9 is 9.

*/

/**
* public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */
public class Solution {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
    Set<KnaryTreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }
  private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set){
    /*
    base case : return root when it is null or equal to any of the targets

    recursive rule : if all children are null, then return null to parent
                     if only one child is not null, then return this child
                     if more than one children are not null, then return current node
    */
    if(root == null || set.contains(root)){
      return root;
    }
    KnaryTreeNode temp = null;
    for(KnaryTreeNode child : root.children){
      KnaryTreeNode cur = helper(child, set);
      if(cur != null){
        if(temp == null){
          temp = cur;
        } else {
          return root;
        }
      }
    }
    return temp;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(height + # of targets)
