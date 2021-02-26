#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m, n;
	cin >> m >> n;
	int tomato = m * n;
	int** map = new int*[n];
	for (int i = 0; i < n; ++i) {
		map[i] = new int[m]{0,};
		for (int j = 0; j < m; ++j) {
			cin >> map[i][j];
		}
	}
	deque<tuple<int, int, int>> deq;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (map[i][j] == 1) {
				deq.push_back(make_tuple(i, j, 0));
			} else if (map[i][j] == -1) {
				tomato--;
			}
		}
	}
	int level = 0;
	int count = 0;
	while (!deq.empty()) {
		const tuple<int, int, int> pos = deq.front();
		deq.pop_front();
		count++;
		int x = get<0>(pos);
		int y = get<1>(pos);
		level = get<2>(pos);

		if (x > 0 && map[x - 1][y] == 0) {
			map[x - 1][y] = 1;
			deq.push_back(make_tuple(x - 1, y, level + 1));
		}
		if (x < n - 1 && map[x + 1][y] == 0) {
			map[x + 1][y] = 1;
			deq.push_back(make_tuple(x + 1, y, level + 1));
		}
		if (y > 0 && map[x][y - 1] == 0) {
			map[x][y - 1] = 1;
			deq.push_back(make_tuple(x, y - 1, level + 1));
		}
		if (y < m - 1 && map[x][y + 1] == 0) {
			map[x][y + 1] = 1;
			deq.push_back(make_tuple(x, y + 1, level + 1));
		}
	}
	if (tomato == count) {
		cout << level;
	} else {
		cout << -1;
	}

}
