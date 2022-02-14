#include <iostream>
#include <cmath>
using namespace std;

int n;
int* arr;
int ans = 0;

void dfs(int depth) {
	if (depth == n) {
		ans++;
	} else {
		for (int i = 0; i < n; ++i) {
			bool pass = true;
			for (int j = 0; j < depth; ++j) {
				if (arr[j] == i || abs(depth - j) == abs(i - arr[j])) {
					pass = false;
					break;
				}
			}
			if (pass) {
				arr[depth] = i;
				dfs(depth + 1);
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	arr = new int[n];
	dfs(0);
	cout << ans;
}