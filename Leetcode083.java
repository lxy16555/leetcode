package test;

//�Ƴ��������ظ��Ĳ��֣�����ظ���ֻ����һ�����֣����⣬˫ָ�봮��
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