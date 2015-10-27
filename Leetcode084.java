package test;

//寻找面积最大的长方形，用stack做，当减小时出栈算面积，当增大时入栈，即确定右边界通过栈找左边界
public class Leetcode084 {
    public int largestRectangleArea(int[] height) {
	//数据结构stack，java里已有，直接用
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