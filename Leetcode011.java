package test;

//�����ٶȲ�����ս�����Ż�
public class Leetcode011 {
	//���ֵ
	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
	
	//��Сֵ
	public int MIN(int a, int b) {
		return a < b ? a : b;
	}
	
	public int maxArea(int[] height) {
		//max��ʾheight�е����ֵ
		//n��ʾheight����
		//indexMax��ʾ���ֵ�±�
		//imax��ʾ���ܵ��������ֵ
		//jmax��ʾ���ܵ��յ�����ֵ
		//maxArea�����������
		int max = 0;
		int n = height.length;
		int indexMax = 0;
		int imax = 0;
		int jmax = 0;
		int maxArea = 0;
		
		//��height���ֵ���±�
		for (int i = 0; i < n - 1; i++)
			if (height[i] >= max) {
				indexMax = i;
				max = height[i];
			}
		
		//��¼���ܵ���㼰�յ�
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
		
		//���ݼ�¼�Ŀ��ܵ��±�Ƚ�������
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
	
	//������
	public static void main(String args[]) {
		int[] height = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Leetcode011 test = new Leetcode011();
		System.out.println(test.maxArea(height));
	}
}
