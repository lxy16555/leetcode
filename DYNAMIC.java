package test;

public class DYNAMIC {
	
	//比较函数
	int MAX(int i, int j) {
		return i > j ? i : j;
	}
	
	//动态规划，占用空间略大
	int DYNAMICPROGRAM(item[] goods, int n, int W) {
		int A[][] = new int[n+1][W+1];
		for(int i=0; i<=n; i++)
			A[i][0] = 0;
		for(int w=0; w<=W; w++)
			A[0][w] = 0;
		for(int i=1; i<=n; i++)
			for(int w=1; w<=W; w++) {
				if(goods[i].weight > w)
					A[i][w] = A[i-1][w];
				else
					A[i][w] = MAX(A[i-1][w], (goods[i].value + A[i-1][w-goods[i].weight]));
			}
		return A[n][W];
	}
	
	//主函数
	public static void main(String args[]) {
		int w[] = {2, 4, 5, 2, 16, 18, 9, 10, 2, 20};
		int p[] = {10, 12, 15, 10, 16, 20, 40, 30, 10, 80};
		item goods[] = new item[11];
		for(int i=1; i<=10; i++)
			goods[i] = new item(w[i-1], p[i-1]);
		
		DYNAMIC test = new DYNAMIC();
		int answer = test.DYNAMICPROGRAM(goods, 10, 40);
		System.out.println(answer);
	}
}

//物品对象
class item {
	public int weight;
	public int value;
	
	item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}
