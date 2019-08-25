/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode partition(ListNode head, int target) {
    ListNode smallHead = new ListNode(0);
    ListNode small = smallHead;
    ListNode largeHead = new ListNode(0);
    ListNode large = largeHead;
    while(head != null){
      if(head.value < target){
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    small.next = largeHead.next;
    large.next = null;
    return smallHead.next;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
