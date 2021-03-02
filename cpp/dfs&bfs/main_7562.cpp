#include <iostream>
#include <queue>
using namespace std;

const int movePosSize = 8;
const pair<int, int> movePos[movePosSize] = {
	make_pair(-2, -1), make_pair(-2, 1), make_pair(-1, -2), make_pair(-1, 2),
	make_pair(1, -2), make_pair(1, 2), make_pair(2, -1), make_pair(2, 1)
};

class position {
public:
	int x, y, level;
	position(const int x, const int y, const int level): x(x), y(y), level(level) {}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int l;
		cin >> l;
		bool** visited = new bool*[l];
		for (int j = 0; j < l; ++j) {
			visited[j] = new bool[l]{false,};
		}
		int startX, startY;
		cin >> startX >> startY;
		int endX, endY;
		cin >> endX >> endY;
		deque<position> deq;
		deq.push_back({startX, startY, 0});
		visited[startX][startY] = true;
		while (!deq.empty()) {
			auto&& pos = deq.front();
			deq.pop_front();
			if (pos.x == endX && pos.y == endY) {
				cout << pos.level << '\n';
				break;
			}
			for (const auto& mp : movePos) {
				const int x = pos.x + mp.first;
				const int y = pos.y + mp.second;
				if (x >= 0 && x < l && y >= 0 && y < l && !visited[x][y]) {
					visited[x][y] = true;
					deq.push_back({x, y, pos.level + 1});
				}
			}
		}
	}
}
