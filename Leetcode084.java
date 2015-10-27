package test;

//Ѱ��������ĳ����Σ���stack��������Сʱ��ջ�������������ʱ��ջ����ȷ���ұ߽�ͨ��ջ����߽�
public class Leetcode084 {
    public int largestRectangleArea(int[] height) {
	//���ݽṹstack��java�����У�ֱ����
        Stack<Integer> stack = new Stack<Integer>();
        
        int index = 0;
        int ans = 0;
        while (index < height.length) {
            if (stack.isEmpty() || height[stack.peek()] < height[index])
                stack.push(index++);
            else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? index : index - stack.peek() - 1;
                ans = ans < h * w ? h * w : ans;
            }
        }
        
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? index : index - stack.peek() - 1;
            ans = ans < h * w ? h * w : ans;
        }
        
        return ans;
    }
}