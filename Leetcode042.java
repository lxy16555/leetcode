package test;

//���ݻ���ȷ������lowbound���������
public class Leetcode042 {
	//������
    public int trap(int[] height) {
    	//��ʼ���ұ߽�
    	int left = 0, right = height.length-1;
    	
    	//���һ����������������ұ߽�
    	while (left <= right && height[left] == 0)
    		left++;
    	while (right >= left && height[right] == 0)
    		right--;
    	
    	//�����߽���ڵ����ұ߽緵��0
    	if (left >= right)
    		return 0;
    	
    	return calcu(height, left, right, 0);
    }
    
    //�����ݻ�
    public int calcu(int[] height, int leftbar, int rightbar, int temp) {
    	//����߽���ڵ����ұ߽緵��temp
    	if (leftbar >= rightbar)
    		return temp;
    	
    	//��߽�Сʱ�����ƽ����ֱ߽�Сʱ�����ƽ�
    	if (height[leftbar] <= height[rightbar]) {
    		int cur = leftbar+1;
    		while (cur <= rightbar && height[cur] < height[leftbar]) {
    			temp += (height[leftbar] - height[cur]);
    			cur++;
    		}
    		return calcu(height, cur, rightbar, temp);
    	} else {
    		int cur = rightbar-1;
    		while (cur >=leftbar && height[cur] < height[rightbar]) {
    			temp += (height[rightbar] - height[cur]);
    			cur--;
    		}
    		return calcu(height, leftbar, cur, temp);
    	}
    }
}
