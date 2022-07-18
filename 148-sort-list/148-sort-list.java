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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null ) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return mergeList(l1, l2);
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2) {
        
        ListNode l = new ListNode(0), iter = l;
        
        while(l1 != null && l2 != null) {
            
            if(l1.val < l2.val){
                iter.next = l1;
                l1 = l1.next;
            }
            else
            {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        
        if(l1 != null) {
            iter.next = l1;
        }
        if(l2 != null)
            iter.next = l2;
        
        return l.next;
    }
}