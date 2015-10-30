package test;

//合并排序的特殊版本，结果存在nums1里，不用extra space的O(n)算法
public class Leetcode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            for (int i=0; i<n; i++)
                nums1[i] = nums2[i];
            return;
        }
        
        int i = m-1, j = n-1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[i+j+1] = nums2[j];
                j--;
            } else {
                nums1[i+j+1] = nums1[i];
                i--;
            }
        }
        
        if (j < 0) {
            return;
        }
        
        if (i < 0) {
            while (j >= 0) {
                nums1[j] = nums2[j];
                j--;
            }
        }
    }
}