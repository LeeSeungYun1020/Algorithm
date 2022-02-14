#include <iostream>
#include <deque>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;
	deque<int> deq;
	deque<int> out;
	for (int i = 1; i <= n; ++i) {
		deq.push_back(i);
	}
	for (int i = 0; i < m; ++i) {
		int num;
		cin >> num;
		out.push_back(num);
	}
	
	int calc = 0;
	while (!out.empty()) {
		int index = 0;
		for (auto && value : deq) {
			if (value == out.front()) {
				out.pop_front();
				break;
			}
			index++;
		}
		const int cmp = deq.size() - index;
		if (index <= cmp) {
			for (int i = 0; i < index; ++i) {
				deq.push_back(deq.front());
				deq.pop_front();
			}
			calc += index;
		} else {
			for (int i = 0; i < cmp; ++i) {
				deq.push_front(deq.back());
				deq.pop_back();
			}
			calc += cmp;
		}
		deq.pop_front();
	}
	cout << calc << '\n';
}
