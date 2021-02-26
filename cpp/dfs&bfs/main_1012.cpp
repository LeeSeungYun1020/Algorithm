#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count;
	cin >> count;
	for (int c = 0; c < count; ++c) {
		int n, m, k;
		cin >> n >> m >> k;
		bool** map = new bool*[n];
		bool** visited = new bool*[n];
		for (int i = 0; i < n; ++i) {
			map[i] = new bool[m]{false,};
			visited[i] = new bool [m]{false,};
		}
		for (int i = 0; i < k; ++i) {
			int x, y;
			cin >> x >> y;
			map[x][y] = true;
		}
		int ans = 0;
		deque<pair<int, int>> deq;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] && !visited[i][j]) {
					ans++;
					deq.push_back(make_pair(i, j));
					visited[i][j] = true;
					while (!deq.empty()) {
						const pair<int, int> pos = deq.front();
						deq.pop_front();
						int x = get<0>(pos);
						int y = get<1>(pos);

						if (x > 0 && map[x - 1][y] && !visited[x - 1][y]) {
							visited[x - 1][y] = true;
							deq.push_back(make_pair(x - 1, y));
						}
						if (x < n - 1 && map[x + 1][y] && !visited[x + 1][y]) {
							visited[x + 1][y] = true;
							deq.push_back(make_pair(x + 1, y));
						}
						if (y > 0 && map[x][y - 1] && !visited[x][y - 1]) {
							visited[x][y - 1] = true;
							deq.push_back(make_pair(x, y - 1));
						}
						if (y < m - 1 && map[x][y + 1] && !visited[x][y + 1]) {
							visited[x][y + 1] = true;
							deq.push_back(make_pair(x, y + 1));
						}
					}
				}
			}
		}
		cout << ans << '\n';
	}
}
