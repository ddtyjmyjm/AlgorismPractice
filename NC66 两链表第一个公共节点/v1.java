/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

// 参考https://blog.nowcoder.net/n/a0c6c80ab3134c20885a2a12e7b4282b
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1!=null ? p1.next: pHead2;
            p2 = p2!=null ? p2.next: pHead1;
        }
        return p1;
    }
}