/*
Insert a value in a sorted linked list.

Examples

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
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
  public ListNode insert(ListNode head, int value) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    dummy.next = head;
    while(head != null && head.value < value){
      prev = head;
      head = head.next;
    }
    prev.next = new ListNode(value);
    prev.next.next = head;
    return dummy.next;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
