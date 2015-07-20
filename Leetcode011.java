package test;

//运行速度才是挑战，待优化
public class Leetcode011 {
	//最大值
	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
	
	//最小值
	public int MIN(int a, int b) {
		return a < b ? a : b;
	}
	
	public int maxArea(int[] height) {
		//max表示height中的最大值
		//n表示height长度
		//indexMax表示最大值下标
		//imax表示可能的起点的最大值
		//jmax表示可能的终点的最大值
		//maxArea储存最大容量
		int max = 0;
		int n = height.length;
		int indexMax = 0;
		int imax = 0;
		int jmax = 0;
		int maxArea = 0;
		
		//找height最大值及下标
		for (int i = 0; i < n - 1; i++)
			if (height[i] >= max) {
				indexMax = i;
				max = height[i];
			}
		
		//记录可能的起点及终点
		int[] startPoint = new int[indexMax+1];
		int[] endPoint = new int[n-indexMax];
		
		for (int i = 0; i<indexMax+1; i++)
			startPoint[i] = 0;
		for (int j = 0; j<n-indexMax; j++)
			endPoint[j] = 0;
		
		for (int i = 0; i <= indexMax; i++) {
			if (height[i] <= imax)
				continue;
			imax = height[i];
			startPoint[i] = 1;
			if (imax == max)
				break;
		}
		
		for (int i = n - 1; i >= indexMax; i--) {
			if (height[i] <= jmax)
				continue;
			jmax = height[i];
			endPoint[i-indexMax] = 1;
		}
		
		//根据记录的可能的下标比较求容量
		for (int i = 0; i < indexMax+1; i++) {
			if (startPoint[i] == 0)
				continue;
			for (int j = 0; j < n-indexMax; j++) {
				if (endPoint[j] == 0)
					continue;
				maxArea = MAX(maxArea, (indexMax+j-i)*MIN(height[i], height[j+indexMax]));
			}
		}
		return maxArea;
	}
	
	//主函数
	public static void main(String args[]) {
		int[] height = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Leetcode011 test = new Leetcode011();
		System.out.println(test.maxArea(height));
	}
}
