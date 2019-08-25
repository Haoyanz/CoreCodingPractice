/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
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
  public ListNode mergeSort(ListNode head) {
    //base case
    if(head == null || head.next == null){
      return head;
    }
    //recursive rule
    ListNode mid = getMid(head);
    ListNode midNext = mid.next;
    mid.next = null;  //cut linked list
    ListNode left = mergeSort(head);
    ListNode right = mergeSort(midNext);
    return merge(left, right);
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
  private ListNode merge(ListNode one, ListNode two){
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(one != null && two != null){
      if(one.value < two.value){
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    if(one != null){
      cur.next = one;
    } else {
      cur.next = two;
    }
    return dummy.next;
  }
}
//Time Complexity : O(n log n)
//Space Complexity : O(n)
