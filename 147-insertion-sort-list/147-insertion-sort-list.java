/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode iter = head ;
        
        while(iter != null) {
            
            ListNode prev = dummy;
            
            while(prev.next != null && prev.next.val < iter.val)
                prev = prev.next;
            
            ListNode next = iter.next;
            
            iter.next = prev.next;
            prev.next = iter;
            
            iter = next;
            
        }
        
        return dummy.next;
    }
}