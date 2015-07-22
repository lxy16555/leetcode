package test;

//关键在反转单链表
public class Leetcode025 {
	ListNode test;
	ListNode start;
	ListNode end;
	ListNode pcur;
	
	//判断是否能够反转
	public boolean isKMembers(ListNode head, int k) {
		test = head;
		
		int i = 0;
		while (i < k) {
			if (test != null) {
				i++;
				test = test.next;
				continue;
			}
			return false;
		}
		return true;
	}
	
	//反转单链表，因为java没有头结点，定义pre为前一项
	public ListNode reverse(ListNode pre, int n) {
		start = pre.next;
		end = start;
		pcur = start.next;
		
		for (int i=1; i<n; i++) {
			end.next = pcur.next;
			pcur.next = start;
			pre.next = pcur;
			
			start = pcur;
			pcur = end.next;
		}
		
		return start;
	}
	
	//给定假头结点tail，迭代指向每次反转后最后一项
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		ListNode tail = new ListNode(0);
		tail.next = head;
		
		int i = 0;
		while (isKMembers(cur, k)) {
			if (i == 0) {
				head = reverse(tail, k);
				tail = end;
			}
			else {
				tail.next = reverse(tail, k);
				tail = end;
			}
			i++;
			cur = tail.next;
		}
		
		return head;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = new ListNode(nums[0]);
		ListNode cur = head;
		
		for (int i=1; i<nums.length; i++) {
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		
		int k = 2;
		
		Leetcode025 test = new Leetcode025();
		head = test.reverseKGroup(head, k);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
