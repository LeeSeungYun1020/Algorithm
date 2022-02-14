#include <iostream>
#include <queue>
using namespace std;

int findMaxValue(queue<pair<int, int>>& q) {
	int mx = -1;
	for (int i = 0; i < q.size(); ++i) {
		if (q.front().second > mx) {
			mx = q.front().second;
		}
		q.push(q.front());
		q.pop();
	}
	return mx;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int n, m;
		cin >> n >> m;
		queue<pair<int, int>> que;
		for (int j = 0; j < n; ++j) {
			int num;
			cin >> num;
			que.push(make_pair(j, num));
		}
		int maxVal = findMaxValue(que);
		int page = 1;
		while (!que.empty()) {
			if (que.front().second == maxVal) {
				if (que.front().first == m) {
					break;
				}
				que.pop();
				page++;
				maxVal = findMaxValue(que);
			} else {
				que.push(que.front());
				que.pop();
			}
			
		}
		cout << page << '\n';
	}
}
