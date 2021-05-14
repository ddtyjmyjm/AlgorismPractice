import java.util.*;


public class ListNode {
  int val;
  ListNode next = null;
}


public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head==null || head.next == null || k<=0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        for (int i = 0; i < len / k; i ++ ) {
            for (int j = 1; j < k; j ++ ) {
                // 之前 pre -> cur -> temp -> temp.next
                // 之后 pre -> temp -> cur -> temp.next
                temp = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}