public class Solution {
    //链表倒写，用三个指针不停换位置
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        
        ListNode pre = head;
        for (int i=1; i<m-1; i++)
            pre = pre.next;
        
        ListNode cur, tmp;
        if (m == 1) {
            cur = head;
            tmp = cur.next;
            for (int i=m; i<n; i++) {
                cur.next = tmp.next;
                tmp.next = head;
                head = tmp;
                tmp = cur.next;
            }
        } else {
            cur = pre.next;
            tmp = cur.next;
            for (int i=m; i<n; i++) {
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
                tmp = cur.next;
            }
        }
        
        return head;
    }
}
