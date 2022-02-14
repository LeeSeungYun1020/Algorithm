#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	cin >> n >> m;
	vector<string> map(n);
	bool** visited = new bool*[n];
	for (int i = 0; i < n; ++i) {
		cin >> map[i];
		visited[i] = new bool [m]{false,};
	}
	deque<tuple<int, int, int>> deq;
	deq.push_back(make_tuple(0, 0, 1));
	visited[0][0] = true;
	while (!deq.empty()) {
		const tuple<int, int, int> pos = deq.front();
		deq.pop_front();
		int x = get<0>(pos);
		int y = get<1>(pos);
		int level = get<2>(pos);
		if (x == n - 1 && y == m - 1) {
			cout << level;
			return 0;
		}
		if (x > 0 && map[x - 1][y] == '1' && !visited[x - 1][y]) {
			visited[x - 1][y] = true;
			deq.push_back(make_tuple(x - 1, y, level + 1));
		}
		if (x < n - 1 && map[x + 1][y] == '1' && !visited[x + 1][y]) {
			visited[x + 1][y] = true;
			deq.push_back(make_tuple(x + 1, y, level + 1));
		}
		if (y > 0 && map[x][y - 1] == '1' && !visited[x][y - 1]) {
			visited[x][y - 1] = true;
			deq.push_back(make_tuple(x, y - 1, level + 1));
		}
		if (y < m - 1 && map[x][y + 1] == '1' && !visited[x][y + 1]) {
			visited[x][y + 1] = true;
			deq.push_back(make_tuple(x, y + 1, level + 1));
		}
	}
}
