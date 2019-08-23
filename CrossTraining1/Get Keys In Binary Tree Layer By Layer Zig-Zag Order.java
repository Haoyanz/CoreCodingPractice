/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases

What if the binary tree is null? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
    
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
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null){
      return list;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offer(root);
    int level = 1;
    /*
    deque stores TreeNodes in current level from left to right
    odd level : expand right, generate left, right child first
    even level : expand left, generate right, left child first
    */
    while(!deque.isEmpty()){
      int size = deque.size();
      if(level % 2 == 1){
        for(int i = 0; i < size; i++){
          TreeNode cur = deque.pollLast();
          list.add(cur.key);
          if(cur.right != null){
            deque.offerFirst(cur.right);
          }
          if(cur.left != null){
            deque.offerFirst(cur.left);
          }
        }
      } else {
        for(int i = 0; i < size; i++){
          TreeNode cur = deque.pollFirst();
          list.add(cur.key);
          if(cur.left != null){
            deque.offerLast(cur.left);
          }
          if(cur.right != null){
            deque.offerLast(cur.right);
          }
        }
      }
      level++;
    }
    return list;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(n) deque stores TreeNodes
