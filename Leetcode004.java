package test;

public class Leetcode004 {
	//取较小值
	int MIN(int i, int j) {
		return i < j ? i : j;
	}
	
	//找到第k小的数字
	public double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int length1 = end1 - start1 + 1;
		int length2 = end2 - start2 + 1;
		int a;
		
		//保持nums1个数不大于nums2
		if (length1 > length2)
			return findKth(nums2, start2, end2, nums1, start1, end1, k);
		
		//考虑空数组，上一步已转换nums1个数较少
		if (length1 <= 0)
			return (double) nums2[start2 + k - 1];
		
		//避免出现k/2 = 0，直接取值
		if (k == 1)
			return (double) MIN(nums1[start1], nums2[start2]);
		
		//迭代取值，二分法
		a = MIN(k / 2, length1);
		if (nums1[start1 + a - 1] < nums2[start2 + k - a - 1])
			return findKth(nums1, start1 + a, end1, nums2, start2, end2, k - a);
		else if (nums1[start1 + a - 1] > nums2[start2 + k - a - 1])
			return findKth(nums1, start1, end1, nums2, start2 + k - a, end2, a);
		else
			return (double) nums1[start1 + a - 1];
	}
	
	//取中值函数
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if ((m + n) % 2 == 1)
			return findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n+1)/2);
		else {
			double left = findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2);
			double right = findKth(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1);
			return (left + right) / 2;
		}
	}
	
	//主函数
	public static void main(String args[]) {
		int nums1[] = {1,2};
		int nums2[] = {1,2};
		
		Leetcode004 test = new Leetcode004();
		double ans = test.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}
}
