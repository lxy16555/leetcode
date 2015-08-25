package test;

//求容积，确定左右lowbound，交替求解
public class Leetcode042 {
	//主函数
    public int trap(int[] height) {
    	//初始左右边界
    	int left = 0, right = height.length-1;
    	
    	//求第一个大于零的数作左右边界
    	while (left <= right && height[left] == 0)
    		left++;
    	while (right >= left && height[right] == 0)
    		right--;
    	
    	//如果左边界大于等于右边界返回0
    	if (left >= right)
    		return 0;
    	
    	return calcu(height, left, right, 0);
    }
    
    //计算容积
    public int calcu(int[] height, int leftbar, int rightbar, int temp) {
    	//当左边界大于等于右边界返回temp
    	if (leftbar >= rightbar)
    		return temp;
    	
    	//左边界小时向右推进，又边界小时向左推进
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
