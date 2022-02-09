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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter= head;
        ListNode prev = head;
        int count =0;
        while(iter.next != null){
            count++;
            iter = iter.next;
            
        }
        count++;
        System.out.println("count "+count);
       
        
        iter = head;
        for(int i=0;i<(count-n);i++)
        { 
            prev = iter;
            iter = iter.next;
        }
        System.out.println("last iter"+iter.val);
            
        prev.next =iter.next;
        
        if(count == n)
            return head.next;
        else
            return head;
    }
}