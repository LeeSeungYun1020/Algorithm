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

	int n;
	cin >> n;
	vector<string> map(n);
	bool** visited = new bool*[n];
	for (int i = 0; i < n; ++i) {
		cin >> map[i];
		visited[i] = new bool [n]{false,};
	}
	deque<pair<int, int>> deq;
	vector<int> block;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (map[i][j] == '1' && !visited[i][j]) {
				int house = 0;
				deq.push_back(make_pair(i, j));
				visited[i][j] = true;
				while (!deq.empty()) {
					house++;
					const pair<int, int> pos = deq.front();
					deq.pop_front();
					int x = pos.first;
					int y = pos.second;
					if (x > 0 && map[x - 1][y] == '1' && !visited[x - 1][y]) {
						visited[x - 1][y] = true;
						deq.push_back(make_pair(x - 1, y));
					}
					if (x < n - 1 && map[x + 1][y] == '1' && !visited[x + 1][y]) {
						visited[x + 1][y] = true;
						deq.push_back(make_pair(x + 1, y));
					}
					if (y > 0 && map[x][y - 1] == '1' && !visited[x][y - 1]) {
						visited[x][y - 1] = true;
						deq.push_back(make_pair(x, y - 1));
					}
					if (y < n - 1 && map[x][y + 1] == '1' && !visited[x][y + 1]) {
						visited[x][y + 1] = true;
						deq.push_back(make_pair(x, y + 1));
					}
				}
				block.push_back(house);
			}
		}
	}
	sort(block.begin(), block.end());
	cout << block.size() << '\n';
	for (auto house : block) cout << house << '\n';
}
