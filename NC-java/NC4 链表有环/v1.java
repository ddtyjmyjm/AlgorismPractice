/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        
        ListNode f = head.next;
        ListNode s = head;
        
        while(f!=null && f.next!=null){
            if(f == s)
                return true;
            s = s.next;
            f = f.next;
            if(f == s)
                return true;
            f = f.next;
        }
        return false;
    }
}