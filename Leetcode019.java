package test;

//��¼��ɾ��ǰһ�������һ����Ȼ�����ұ�������endΪnull��˵���ҵ���ɾ��cur.next
public class Leetcode019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		ListNode end = cur;

		for (int i=0; i<n; i++)
			end = end.next;	
		
		//����:��ɾ����Ϊͷָ�룬�����صڶ���ָ��Ϊͷָ��
		if (end == null)
			return cur.next;
		
		while (end.next != null) {
			cur = cur.next;
			end = end.next;
		}
		
		cur.next = cur.next.next;
		return head;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 2};
		
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for (int i=1; i< nums.length; i++) {
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		
		Leetcode019 test = new Leetcode019();
		head = test.removeNthFromEnd(head, 2);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}