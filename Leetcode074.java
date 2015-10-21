package test;

//找2D矩阵中是否有target数，第一想法binary research
public class Leetcode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        return binarySearch(0, 0, m-1, n-1, matrix, target);
    }
    
    //考虑行列分别的起点
    public boolean binarySearch(int startM, int startN, int endM, int endN, int[][] matrix, int target) {
        //首先考虑行变化，注意startM处需要+1
        if (startM != endM) {
            int m = (startM + endM) / 2;
            if (matrix[m][endN] < target) {
                startM = m+1;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else if (matrix[m][endN] > target) {
                endM = m;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else {
                return true;
            }
        } else {
            if (startN == endN)
                    return (matrix[startM][startN] == target);
            
	    //考虑列变化，注意startN每次也要+1，endN不用-1
            int n = (startN + endN) / 2;
            if (matrix[startM][n] < target) {
                startN = n+1;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else if (matrix[startM][n] > target) {
                endN = n;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else {
                return true;
            }
        }
    }
}