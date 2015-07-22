package test;

//分治法，有点不太明白为何此方法快，合并次数与插入法相当，此方法leetcode上跑为380ms
public class Leetcode023 {
	public ListNode merge(int l1, int l2, ListNode[] lists) {
		if (lists[l1] == null)
			return lists[l2];
		
		if (lists[l2] == null)
			return lists[l1];
		
		ListNode head;
		ListNode cur;
		if (lists[l1].val <= lists[l2].val) {
			head = lists[l1];
			lists[l1] = lists[l1].next;
		} else {
			head = lists[l2];
			lists[l2] = lists[l2].next;
		}
		cur = head;
		
		while (lists[l1] != null && lists[l2] != null) {
			if (lists[l1].val <= lists[l2].val) {
				cur.next = lists[l1];
				cur = cur.next;
				lists[l1] = lists[l1].next;
			} else {
				cur.next = lists[l2];
				cur = cur.next;
				lists[l2] = lists[l2].next;
			}
		}
		
		if (lists[l1] == null)
			cur.next = lists[l2];
		if (lists[l2] == null)
			cur.next = lists[l1];
		
		return head;
	}
	
	public void devide(int start, int end, ListNode[] lists) {
		if (start < end) {
			devide(start, (start+end)/2, lists);
			devide((start+end)/2+1, end, lists);
			lists[start] = merge(start, (start+end)/2+1, lists);
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		
		devide(0, lists.length-1, lists);
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
