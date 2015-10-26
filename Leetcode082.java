package test;

//删除链表中重复的数字，只留下不重复的数字，下一道题的升级版，code待改进
public class Leetcode082 {
    //找下一个数字，先不考虑下一个数字是否重复
    public ListNode findNextValue(ListNode head) {
        while (head.next != null && head.val == head.next.val)
            head = head.next;
        
        return head.next;
    }
    
    public ListNode deleteDuplicates(ListNode head) {
	//找新的头结点，如果新的头结点为空或者没有下一个节点，直接返回
        if (head == null || head.next == null)
            return head;
        
        ListNode newhead = head;
        
        if (head.val == head.next.val)
            while (newhead != null && newhead.next != null && newhead.val == newhead.next.val)
                newhead = findNextValue(newhead);
        
        if (newhead == null || newhead.next == null)
            return newhead;
        
        //双指针，pre表示上一个待指的指针，cur表示现在遍历的
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