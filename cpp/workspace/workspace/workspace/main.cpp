#include <iostream>
#include <queue>
#include <vector>
using namespace std;

enum class state {
	NOT_VISITED,
	LEFT,
	RIGHT,
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int v, e;
		cin >> v >> e;
		vector<int>* connection = new vector<int>[v + 1];
		state* visited = new state[v + 1]{state::NOT_VISITED};
		deque<int> deq;
		for (int j = 1; j <= e; ++j) {
			int a, b;
			cin >> a >> b;
			connection[a].push_back(b);
			connection[b].push_back(a);
		}

		bool pass = true;
		for (int k = 1; k <= v; ++k) {
			if (visited[k] == state::NOT_VISITED) {
				visited[k] = state::RIGHT;
				deq.push_back(k);
				while (!deq.empty()) {
					const int pos = deq.front();
					deq.pop_front();
					for (auto cmp : connection[pos]) {
						if (visited[cmp] == state::NOT_VISITED) {
							if (visited[pos] == state::RIGHT) {
								visited[cmp] = state::LEFT;
							} else {
								visited[cmp] = state::RIGHT;
							}
							deq.push_back(cmp);
						} else if (visited[cmp] == visited[pos]) {
							pass = false;
							break;
						}
					}
					if (!pass) break;
				}
			}
			if (!pass) break;
		}
		if (pass) cout << "YES\n";
		else cout << "NO\n";
		delete[] connection;
		delete[] visited;
	}
}
