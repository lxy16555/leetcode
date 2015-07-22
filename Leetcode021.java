package test;

public class Leetcode021 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
		
		Leetcode021 test = new Leetcode021();
		head1 = test.mergeTwoLists(head1, head2);
		
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}
}
