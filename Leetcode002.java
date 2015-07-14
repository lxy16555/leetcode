package test;

public class Leetcode002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//插入头结点
		int temp = l1.val + l2.val;
		ListNode first = new ListNode(temp % 10);
		ListNode last = first;
		int pos = temp / 10;
		l1 = l1.next;
		l2 = l2.next;
		
		//进位
		while (l1 != null && l2 != null) {
			temp = l1.val + l2.val;
			last.next = new ListNode((pos + temp) % 10);
			last = last.next;
			pos = (pos + temp) / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 == null || l2 == null) {
			if (l1 != null) {
				last.next = new ListNode((pos + l1.val) % 10);
				last = last.next;
				pos = (pos + l1.val) / 10;
				l1 = l1.next;
			}
			else if (l2 != null) {
				last.next = new ListNode((pos + l2.val) % 10);
				last = last.next;
				pos = (pos + l2.val) / 10;
				l2 = l2.next;
			}
			else {
				if (pos == 1) {
					last.next = new ListNode(pos);
					last = last.next;
				}
				break;
			}
		}
		
		return first;
	}
	
	public static void main(String args[]) {
		
		//初始化输入
		int num1 = 42;
		int num2 = 465;
		ListNode first1 = new ListNode(num1 % 10);
		ListNode first2 = new ListNode(num2 % 10);
		ListNode last1 = first1;
		ListNode last2 = first2;
		num1 = num1 / 10;
		num2 = num2 / 10;
		while (num1 > 0) {
			last1.next = new ListNode(num1 % 10);
			last1 = last1.next;
			num1 = num1 / 10;
		}
		while (num2 > 0) {
			last2.next = new ListNode(num2 % 10);
			last2 = last2.next;
			num2 = num2 / 10;
		}
		
		//测试
		Leetcode002 test = new Leetcode002();
		ListNode target = test.addTwoNumbers(first1, first2);
		while (target != null) {
			System.out.println(target.val);
			target = target.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {this.val = x;}
}