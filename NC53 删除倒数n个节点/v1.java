import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null)
            return null;
        ListNode dummpy = new ListNode(-1);
        ListNode l = dummpy;
        ListNode r = dummpy;
        dummpy.next = head;
        for(int i=0; i<=n; i++ ){
            r = r.next;
        }
        while(r!=null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummpy.next;
    }
}