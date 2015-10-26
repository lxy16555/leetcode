package test;

//移除链表中重复的部分，多个重复的只留下一个数字，简单题，双指针串联
public class Leetcode083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;
        
        while (cur != null && cur.next != null) {
            cur = cur.next;
            if (pre.val != cur.val) {
                pre.next = cur;
                pre = pre.next;
            }
        }
        
        if (pre != null)
            pre.next = null;
        
        return head;
    }
}