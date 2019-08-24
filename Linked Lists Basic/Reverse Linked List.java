/*
Reverse a singly-linked list

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

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
  public ListNode reverseIterative(ListNode head) {
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  
  public ListNode reverseRecursive(ListNode head) {
    //corner case
    if(head == null){
      return head;
    }
    //base case
    if(head.next == null){
      return head;
    }
    ListNode newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
