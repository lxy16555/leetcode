package test;

//顺时针旋转n*n图片90°，挑战在常量空间完成
public class Leetcode048 {
    //主函数
    public void rotate(int[][] matrix) {
        //记录temp，n为matrix长度
        int temp;
        int n = matrix.length;

        //循环改变位置，从外圈到内圈，注意最后一位不用再次旋转！
        for (int i=0; i<=(n-1)/2; i++)
            for (int j=i; j<(n-i-1); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
    }
}