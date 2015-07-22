package test;

//插入排序，一个一个合并，运行速度644ms，比分治法慢非常多
public class Leetcode023ver2 {
	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		
		if (l2 == null)
			return l1;
		
		ListNode head;
		ListNode cur;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		cur = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
		
		if (l1 == null)
			cur.next = l2;
		if (l2 == null)
			cur.next = l1;
		
		return head;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		
		for (int i=1; i<lists.length; i++)
			lists[0] = merge(lists[0], lists[i]);
		
		return lists[0];
	}
	
	public static void main(String args[]) {
		int[] nums1 = {2};
		int[] nums2 = {1};
		
		ListNode head1 = new ListNode(2);
		ListNode cur1 = head1;
		for (int i=1; i< nums1.length; i++) {
			cur1.next = new ListNode(nums1[i]);
			cur1 = cur1.next;
		}
		
		ListNode head2 = new ListNode(1);
		ListNode cur2 = head2;
		for (int i=1; i< nums2.length; i++) {
			cur2.next = new ListNode(nums2[i]);
			cur2 = cur2.next;
		}
		
		ListNode[] lists = {head1, head2};
		
		Leetcode023 test = new Leetcode023();
		head1 = test.mergeKLists(lists);
		
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}
}