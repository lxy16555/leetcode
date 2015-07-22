package test;

//�ؼ��ڷ�ת������
public class Leetcode025 {
	ListNode test;
	ListNode start;
	ListNode end;
	ListNode pcur;
	
	//�ж��Ƿ��ܹ���ת
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
	
	//��ת��������Ϊjavaû��ͷ��㣬����preΪǰһ��
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
	
	//������ͷ���tail������ָ��ÿ�η�ת�����һ��
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
