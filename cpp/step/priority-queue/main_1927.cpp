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
	vector<int> heap;
	for (int i = 0; i < n; ++i) {
		cin >> tem;
		if (tem == 0) {
			if (heap.empty()) {
				cout << 0 << '\n';
			} else {
				cout << heap.front() << '\n';
				pop_heap(heap.begin(), heap.end(), greater<int>());
				heap.pop_back();
			}
		} else {
			heap.push_back(tem);
			push_heap(heap.begin(), heap.end(), greater<int>());
		}
	}
}
