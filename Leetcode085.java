package test;

//计算0,1矩阵中全部为1的最大子矩阵的面积，将每一行看做一个数组求面积题(084)
public class Leetcode085 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        
        int[] height = new int[n];
        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '1')
                    height[j] = height[j] + 1;
                else
                    height[j] = 0;
            }
            int temp = largestRectangleArea(height);
            ans = ans > temp ? ans : temp;
        }
        
        return ans;
    }
    
    public int largestRectangleArea(int[] height) {
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