#include <iostream>
#include <cmath>
using namespace std;

const int n = 9;
int arr[9][9] = {{0,},};

bool canPosition(int x, int y, int value) {
	for (int i = 0; i < n; ++i) {
		if (arr[x][i] == value || arr[i][y] == value) {
			return false;
		}
	}
	for (int j = x / 3 * 3; j < (x / 3 + 1) * 3; ++j) {
		for (int k = y / 3 * 3; k < (y / 3 + 1) * 3; ++k) {
			if (arr[j][k] == value) {
				return false;
			}
		}
	}
	return true;
}

void dfs(int depth) {
	if (depth == n * n) {
		for (auto& i : arr) {
			for (int j : i) {
				cout << j << ' ';
			}
			cout << '\n';
		}
		exit(0);
	}
	const int x = depth / 9;
	const int y = depth % 9;

	if (arr[x][y] == 0) {
		for (int i = 1; i <= n; ++i) {
			if (canPosition(x, y, i)) {
				arr[x][y] = i;
				dfs(depth + 1);
				arr[x][y] = 0;
			}

		}
	} else {
		dfs(depth + 1);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	for (auto& i : arr) {
		for (int& j : i) {
			cin >> j;
		}
	}
	dfs(0);
}
