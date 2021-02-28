#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;
	const int size = 100001;
	bool* visited = new bool [size]{false,};
	deque<pair<int, int>> deq;
	deq.push_back(make_pair(n, 0));
	visited[n] = true;
	while (!deq.empty()) {
		const auto value = deq.front();
		const int pos = value.first;
		const int level = value.second;
		deq.pop_front();
		if (pos == k) {
			cout << level << endl;
			return 0;
		}
		if (pos > 0 && !visited[pos - 1]) {
			visited[pos - 1] = true;
			deq.push_back(make_pair(pos - 1, level + 1));
		}
		if (pos + 1 < size && !visited[pos + 1]) {
			visited[pos + 1] = true;
			deq.push_back(make_pair(pos + 1, level + 1));
		}
		if (pos * 2 < size && !visited[pos * 2]) {
			visited[pos * 2] = true;
			deq.push_back(make_pair(pos * 2, level + 1));
		}
	}
}
