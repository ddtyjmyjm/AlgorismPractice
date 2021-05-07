/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node = new ListNode(head.val);
        
        for (ListNode p = head.next; p != null; p = p.next){
            ListNode newNode = new ListNode(p.val);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }
}