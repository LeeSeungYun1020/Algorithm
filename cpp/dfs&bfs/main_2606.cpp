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

	int n, m;
	cin >> n >> m;
	set<pair<int, int>> connection;
	for (int i = 0; i < m; ++i) {
		int x, y;
		cin >> x >> y;
		connection.insert(make_pair(min(x, y), max(x, y)));
	}
	bool* visited = new bool[n + 1]{false,};
	deque<int> deq;
	int ans = 0;
	deq.push_back(1);
	visited[1] = true;
	while (!deq.empty()) {
		const int value = deq.front();
		deq.pop_front();
		for (auto&& l : connection) {
			if (l.first == value && !visited[l.second]) {
				deq.push_back(l.second);
				visited[l.second] = true;
				ans++;
			} else if (l.second == value && !visited[l.first]) {
				deq.push_back(l.first);
				visited[l.first] = true;
				ans++;
			}
		}
	}
	cout << ans;
}
