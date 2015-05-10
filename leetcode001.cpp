//============================================================================
// Name        : leetcode001.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <algorithm>
#include <stddef.h>
using namespace std;

struct Node {         //define a struct including index and value of a vector
	int index;
	int value;
	Node(int i, int v): index(i), value(v){} //define the elements of a struct Node
};

bool compare(const Node &left, const Node &right) {   //compare if the vector is set up from small to large
	return left.value < right.value;
}

class Solution {
public:
	vector<int> twoSum(vector<int> &numbers, int target) {
		vector <Node> a;
		for(int i=0; i<numbers.size(); i++) {
			a.push_back(Node(i+1, numbers[i]));
		}
		std::sort(a.begin(), a.end(), compare);
		int beg = 0;
		int end = a.size() - 1;

		while (beg < end) {
			int sum = a[beg].value + a[end].value;
			if (sum==target) {
				int small = std::min(a[beg].index, a[end].index);
				int big = std::max(a[beg].index, a[end].index);
				vector<int> ret;
				ret.push_back(small);
				ret.push_back(big);
				return ret;
			}
			else if(sum < target) {
				beg++;
			}
			else {
				end--;
			}
		}
	}
};

int main()
{
	int da[5] = {2,5,7,11,15};
	vector<int> data;
	int i=0;
	while(i<5)
	{
		data.push_back(da[i]);
		i++;
	}
	vector<int> result;
	int target = 9;
	Solution test;
	result = test.twoSum(data, target);
	cout<<data.size()<<endl;
	cout<<result.at(0)<<endl<<result.at(1)<<endl;

	int *p = NULL;
	if(p)
		cout<<p;
}
