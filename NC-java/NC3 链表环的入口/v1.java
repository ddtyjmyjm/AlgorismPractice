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
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(f==s){
                ListNode s2 = head;
                while(s!=s2){
                    s = s.next;
                    s2 = s2.next;
                }
                 return s;
            }
        }
        return null;
    }
}