package test;

//ɾ���������ظ������֣�ֻ���²��ظ������֣���һ����������棬code���Ľ�
public class Leetcode082 {
    //����һ�����֣��Ȳ�������һ�������Ƿ��ظ�
    public ListNode findNextValue(ListNode head) {
        while (head.next != null && head.val == head.next.val)
            head = head.next;
        
        return head.next;
    }
    
    public ListNode deleteDuplicates(ListNode head) {
	//���µ�ͷ��㣬����µ�ͷ���Ϊ�ջ���û����һ���ڵ㣬ֱ�ӷ���
        if (head == null || head.next == null)
            return head;
        
        ListNode newhead = head;
        
        if (head.val == head.next.val)
            while (newhead != null && newhead.next != null && newhead.val == newhead.next.val)
                newhead = findNextValue(newhead);
        
        if (newhead == null || newhead.next == null)
            return newhead;
        
        //˫ָ�룬pre��ʾ��һ����ָ��ָ�룬cur��ʾ���ڱ�����
        ListNode pre = newhead;
        ListNode cur = newhead.next;
        
        while (cur != null && cur.next != null) {
            while (cur != null && cur.next != null && cur.val == cur.next.val)
                cur = findNextValue(cur);
            
            if (cur == null)
                break;
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        
        if (cur != null) {
            pre.next = cur;
            pre = pre.next;
        }
        
        pre.next = null;
        return newhead;
    }
}