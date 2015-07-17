package test;

public class Leetcode006 {
	public String convert(String s, int numRows) {
		String ans = null;
		
		//加快运行时间，过滤低级zigzag
		if (numRows == 1)
			return s;
		
		int next = 2 * numRows - 2;
		
		//第一行及最后一行不同，其他相同，时间长
		for (int i=0; i<numRows; i++) {
			int j=i;
			if (i == 0 || i == numRows-1) {
				while (j<s.length()) {
					if (j == 0)
						ans = String.valueOf(s.charAt(j));
					else
						ans = ans + s.charAt(j);
					j = j + next;
				}
			} else {
				while (j+next-2*i<s.length()) {
					ans = ans + s.charAt(j) + s.charAt(j+next-2*i);
					j = j + next;
				}
				if (j<s.length())
					ans = ans + s.charAt(j);
			}
		}
		return ans;
	}
	
	public static void main(String args[]) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String ans;
		
		Leetcode006 test = new Leetcode006();
		ans = test.convert(s, numRows);
		System.out.println(ans);
	}
}
