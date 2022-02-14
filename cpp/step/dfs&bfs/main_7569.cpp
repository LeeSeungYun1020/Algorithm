#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m, n, h;
	cin >> m >> n >> h;
	int tomato = m * n * h;
	int*** map = new int**[h];
	deque<pair<tuple<int, int, int>, int>> deq;
	for (int i = 0; i < h; ++i) {
		map[i] = new int*[n];
		for (int j = 0; j < n; ++j) {
			map[i][j] = new int[m];
			for (int k = 0; k < m; ++k) {
				cin >> map[i][j][k];
				if (map[i][j][k] == 1) {
					deq.push_back(make_pair(make_tuple(i, j, k), 0));
				} else if (map[i][j][k] == -1) {
					tomato--;
				}
			}
		}
	}

	int level = 0;
	int count = 0;
	while (!deq.empty()) {
		const tuple<int, int, int> pos = deq.front().first;
		level = deq.front().second;
		deq.pop_front();
		count++;
		int x = get<0>(pos);
		int y = get<1>(pos);
		int z = get<2>(pos);

		if (x > 0 && map[x - 1][y][z] == 0) {
			map[x - 1][y][z] = 1;
			deq.push_back(make_pair(make_tuple(x - 1, y, z), level + 1));
		}
		if (x < h - 1 && map[x + 1][y][z] == 0) {
			map[x + 1][y][z] = 1;
			deq.push_back(make_pair(make_tuple(x + 1, y, z), level + 1));
		}
		if (y > 0 && map[x][y - 1][z] == 0) {
			map[x][y - 1][z] = 1;
			deq.push_back(make_pair(make_tuple(x, y - 1, z), level + 1));
		}
		if (y < n - 1 && map[x][y + 1][z] == 0) {
			map[x][y + 1][z] = 1;
			deq.push_back(make_pair(make_tuple(x, y + 1, z), level + 1));
		}
		if (z > 0 && map[x][y][z - 1] == 0) {
			map[x][y][z - 1] = 1;
			deq.push_back(make_pair(make_tuple(x, y, z - 1), level + 1));
		}
		if (z < m - 1 && map[x][y][z + 1] == 0) {
			map[x][y][z + 1] = 1;
			deq.push_back(make_pair(make_tuple(x, y, z + 1), level + 1));
		}
	}
	if (tomato == count) {
		cout << level;
	} else {
		cout << -1;
	}

}
