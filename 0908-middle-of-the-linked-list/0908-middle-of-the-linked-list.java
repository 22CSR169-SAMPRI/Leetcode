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
    public ListNode middleNode(ListNode head) {
        // if(head.next == null)
        //     return head;
        // ListNode temp = head;
        // int t = 0;
        // while(temp.next != null){
        //     temp = temp.next;
        //     t++;
        // }
        // t = (t + 1) / 2;
        // while(t > 0){
        //     head = head.next;
        //     t--;
        // }
        // return head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}