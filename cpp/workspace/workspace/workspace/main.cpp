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
	bool*** visited = new bool**[n];
	for (int i = 0; i < n; ++i) {
		cin >> map[i];
		visited[i] = new bool*[m];
		for (int j = 0; j < m; ++j) {
			visited[i][j] = new bool[2]{false, false};
		}
	}
	deque<pair<tuple<int, int, bool>, int>> deq;
	deq.push_back(make_pair(make_tuple(0, 0, false), 1));
	visited[0][0][false] = true;
	while (!deq.empty()) {
		const auto pos = deq.front().first;
		const int x = get<0>(pos);
		const int y = get<1>(pos);
		const bool isBreak = get<2>(pos);
		const int level = deq.front().second;
		deq.pop_front();
		if (x == n - 1 && y == m - 1) {
			cout << level;
			return 0;
		}
		if (x > 0 && map[x - 1][y] == '0' && !visited[x - 1][y][isBreak]) {
			visited[x - 1][y][isBreak] = true;
			deq.push_back(make_pair(make_tuple(x - 1, y, isBreak), level + 1));
		}
		if (x > 0 && map[x - 1][y] == '1' && !isBreak && !visited[x - 1][y][false]) {
			visited[x - 1][y][false] = true;
			deq.push_back(make_pair(make_tuple(x - 1, y, true), level + 1));
		}
		if (x < n - 1 && map[x + 1][y] == '0' && !visited[x + 1][y][isBreak]) {
			visited[x + 1][y][isBreak] = true;
			deq.push_back(make_pair(make_tuple(x + 1, y, isBreak), level + 1));
		}
		if (x < n - 1 && map[x + 1][y] == '1' && !isBreak && !visited[x + 1][y][false]) {
			visited[x + 1][y][false] = true;
			deq.push_back(make_pair(make_tuple(x + 1, y, true), level + 1));
		}
		if (y > 0 && map[x][y - 1] == '0' && !visited[x][y - 1][isBreak]) {
			visited[x][y - 1][isBreak] = true;
			deq.push_back(make_pair(make_tuple(x, y - 1, isBreak), level + 1));
		}
		if (y > 0 && map[x][y - 1] == '1' && !isBreak && !visited[x][y - 1][false]) {
			visited[x][y - 1][false] = true;
			deq.push_back(make_pair(make_tuple(x, y - 1, true), level + 1));
		}
		if (y < m - 1 && map[x][y + 1] == '0' && !visited[x][y + 1][isBreak]) {
			visited[x][y + 1][isBreak] = true;
			deq.push_back(make_pair(make_tuple(x, y + 1, isBreak), level + 1));
		}
		if (y < m - 1 && map[x][y + 1] == '1' && !isBreak && !visited[x][y + 1][false]) {
			visited[x][y + 1][false] = true;
			deq.push_back(make_pair(make_tuple(x, y + 1, true), level + 1));
		}
	}
	cout << -1;
	return 0;
}
