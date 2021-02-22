#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, tem;
	cin >> n;
	vector<int> minHeap, maxHeap;
	for (int i = 0; i < n; ++i) {
		cin >> tem;
		if (minHeap.size() == maxHeap.size()) {
			maxHeap.push_back(tem);
			push_heap(maxHeap.begin(), maxHeap.end());
		} else {
			minHeap.push_back(tem);
			push_heap(minHeap.begin(), minHeap.end(), greater<int>());
		}
		if (!minHeap.empty() && minHeap.front() < maxHeap.front()) {
			const int max = maxHeap.front();
			pop_heap(maxHeap.begin(), maxHeap.end());
			maxHeap.pop_back();
			const int min = minHeap.front();
			pop_heap(minHeap.begin(), minHeap.end(), greater<int>());
			minHeap.pop_back();

			minHeap.push_back(max);
			push_heap(minHeap.begin(), minHeap.end(), greater<int>());
			maxHeap.push_back(min);
			push_heap(maxHeap.begin(), maxHeap.end());
		}
		cout << maxHeap.front() << '\n';
	}
}
