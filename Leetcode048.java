package test;

//˳ʱ����תn*nͼƬ90�㣬��ս�ڳ����ռ����
public class Leetcode048 {
    //������
    public void rotate(int[][] matrix) {
        //��¼temp��nΪmatrix����
        int temp;
        int n = matrix.length;

        //ѭ���ı�λ�ã�����Ȧ����Ȧ��ע�����һλ�����ٴ���ת��
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