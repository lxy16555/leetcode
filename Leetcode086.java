package test;

//���ո���int��С�ֻ�һ��linklist���½�����list������������������recursive�ⷨ
public class Leetcode086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftcur = left;
        ListNode rightcur = right;
        
        while (head != null) {
            if (head.val < x) {
                leftcur.next = head;
                leftcur = leftcur.next;
            }
            else {
                rightcur.next = head;
                rightcur = rightcur.next;
            }
            head = head.next;
        }
        
        leftcur.next = right.next;
        rightcur.next = null;
        return left.next;
    }
}