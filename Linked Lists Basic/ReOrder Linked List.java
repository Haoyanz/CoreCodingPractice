/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> nul
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
  public ListNode reorder(ListNode head) {
    if(head == null){
      return head;
    }
    ListNode mid = getMid(head);
    ListNode midNext = mid.next;
    //cut linked list
    mid.next = null;
    return merge(head, reverse(midNext));
  }
  private ListNode getMid(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  private ListNode merge(ListNode one, ListNode two){
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(one != null && two != null){
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;
      cur = cur.next.next;
    }
    if(one != null){
      cur.next = one;
    }
    return dummy.next;
  }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
