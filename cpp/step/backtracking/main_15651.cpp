#include <iostream>
using namespace std;

int n, m;
int* arr;

void dfs(int depth) {
	if (depth == m) {
		for (int i = 0; i < m; ++i) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
	} else {
		for (int i = 1; i <= n; ++i) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	arr = new int[m];
	dfs(0);
}