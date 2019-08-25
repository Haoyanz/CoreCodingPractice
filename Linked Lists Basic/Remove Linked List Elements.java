/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(head != null){
      if(head.value != val){
        cur.next = head;
        cur = cur.next;
      }
      head = head.next;
    }
    cur.next = null;
    return dummy.next;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
