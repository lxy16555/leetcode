package test;

//变更一对node的顺序，返回头指针，在常亮空间
public class Leetcode024 {
	public ListNode swapPairs(ListNode head) {
		//初始化，当指针少于2位时直接返回
		ListNode pre;
		ListNode cur;
		ListNode pro = null;
		if (head == null || head.next == null)
			return head;
		
		//交换前两位，储存到head，定义cur，pre和pro
		cur = head.next;
		head.next = head.next.next;
		cur.next = head;
		pre = head;
		head = cur;
		cur = pre.next;
		if (cur != null)
			pro = cur.next;
		
		//当cur存在，cur.next存在时才有交换意义
		while (cur != null && cur.next != null) {
			pre.next = pro;
			cur.next = pro.next;
			pro.next = cur;
			
			cur = cur.next;
			pre = pre.next.next;
			if (cur != null)
				pro = cur.next;
		}
		
		return head;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 2, 3, 4};
		ListNode head = new ListNode(nums[0]);
		ListNode cur = head;
		
		for (int i=1; i<nums.length; i++) {
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		
		Leetcode024 test = new Leetcode024();
		head = test.swapPairs(head);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
