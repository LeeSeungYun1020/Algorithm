#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, k;
	cin >> n >> k;
	queue<int> que;

	for (int i = 1; i <= n; ++i) {
		que.push(i);
	}

	int j = 1;
	cout << '<';
	while (que.size() > 1) {
		if (j % k == 0) {
			cout << que.front() << ", ";
			que.pop();
		} else {
			que.push(que.front());
			que.pop();
		}
		j++;
	}

	cout << que.front() << '>';
}
