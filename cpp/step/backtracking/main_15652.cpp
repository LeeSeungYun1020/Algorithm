#include <iostream>
using namespace std;

int n, m;
int* arr;

void dfs(int depth, int start) {
	if (depth == m) {
		for (int i = 0; i < m; ++i) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
	} else {
		for (int i = start; i <= n; ++i) {
			arr[depth] = i;
			dfs(depth + 1, i);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	arr = new int[m];
	dfs(0, 1);
}