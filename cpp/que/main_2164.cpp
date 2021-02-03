#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	queue<int> que;
	for (int i = 1; i <= n; ++i) {
		que.push(i);
	}
	int j = 0;
	while (que.size() > 1) {
		if (j % 2 == 0) {
			que.pop();
		} else {
			que.push(que.front());
			que.pop();
		}
		j++;
	}
	cout << que.front() << '\n';
}