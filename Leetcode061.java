package test;

public class Leetcode061 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode newhead = head;
        ListNode cur = head;
        ListNode pre = head;
        int count = 0;
        
        if (head == null || head.next == null)
            return head;
            
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        
        k = k % count;
        cur = head;
        
        if (k == 0)
            return head;
        
        for (int i=k; i>1; i--) {
            if (cur == null || cur.next == null)
                return head;
            cur = cur.next;
        }
        
        if (cur == null || cur.next == null)
            return head;
        else {
            cur = cur.next;
            newhead = newhead.next;
        }
        
        while (cur.next != null) {
            newhead = newhead.next;
            pre = pre.next;
            cur = cur.next;
        }
        
        cur.next = head;
        pre.next = null;
        
        return newhead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}