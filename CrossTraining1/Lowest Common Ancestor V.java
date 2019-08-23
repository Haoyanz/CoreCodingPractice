/*
Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples



        5

      /   \

     9   12

   / | \      \

 1 2   3      14



The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.

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
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    /*
    base case : if current node is null or equal to any target, then return

    recursive rule : if all children return null, then return null to parent
                     if only one child is not null, then return that node
                     if more than one children is not null, then return parent
    */
    if(root == null || root == a || root == b){
      return root;
    }
    KnaryTreeNode temp = null;
    for(KnaryTreeNode child : root.children){
      KnaryTreeNode cur = lowestCommonAncestor(child, a, b);
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
//Space Complexity : O(heihgt)
