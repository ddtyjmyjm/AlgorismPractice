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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode p1 = reverse(head1);
        ListNode p2 = reverse(head2);
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        int temp=0;
        while(p1!=null || p2!=null){
            if(p1!=null){
                temp += p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                temp += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(temp%10);
            temp = temp/10;
            cur = cur.next;
        }
        if(temp==1){
            cur.next = new ListNode(1);
        }
        
        return reverse(head.next);
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}