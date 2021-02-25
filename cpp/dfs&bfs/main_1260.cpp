#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m, v;
	cin >> n >> m >> v;
	set<pair<int, int>> load;
	for (int i = 0; i < m; ++i) {
		int x, y;
		cin >> x >> y;
		load.insert(make_pair(min(x, y), max(x, y)));
	}
	bool* visited = new bool[n + 1]{false,};
	vector<int> result;
	deque<int> deq;
	deq.push_back(v);
	while (!deq.empty()) {
		const int value = deq.back();
		deq.pop_back();
		if (visited[value]) continue;
		result.push_back(value);
		visited[value] = true;
		vector<int> tem;
		for (auto&& l : load) {
			if (l.first == value && !visited[l.second]) {
				tem.push_back(l.second);
			} else if (l.second == value && !visited[l.first]) {
				tem.push_back(l.first);
			}
		}
		if (!tem.empty()) {
			sort(tem.begin(), tem.end(), greater<int>());
			for (auto val : tem) {
				deq.push_back(val);
			}
		}
	}
	for (auto&& value1 : result) cout << value1 << ' ';
	cout << '\n';

	result.clear();
	delete[] visited;
	visited = new bool[n + 1]{false,};
	deq.push_back(v);
	result.push_back(v);
	visited[v] = true;
	while (!deq.empty()) {
		const int value = deq.front();
		deq.pop_front();
		vector<int> tem;
		for (auto&& l : load) {
			if (l.first == value && !visited[l.second]) {
				tem.push_back(l.second);
			} else if (l.second == value && !visited[l.first]) {
				tem.push_back(l.first);
			}
		}
		if (!tem.empty()) {
			sort(tem.begin(), tem.end());
			for (auto val : tem) {
				deq.push_back(val);
				result.push_back(val);
				visited[val] = true;
			}
		}
	}
	for (auto&& value1 : result) cout << value1 << ' ';
}
