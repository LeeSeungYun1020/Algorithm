#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;
	bool** board = new bool*[n];
	for (int i = 0; i < n; ++i) {
		board[i] = new bool[m] { false, };
		string tem;
		cin >> tem;
		for (int j = 0; j < m; ++j) {
			if (((i + j) % 2 == 0 && tem[j] == 'W') || ((i + j) % 2 == 1 && tem[j] == 'B')) {
				board[i][j] = true;
			}
		}
	}
	int ans = 64;
	for (int i = 0; i <= n - 8; ++i) {
		for (int j = 0; j <= m - 8; ++j) {
			int count = 0;
			for (int k = i; k < i + 8; ++k) {
				for (int l = j; l < j + 8; ++l) {
					if (board[k][l]) {
						count++;
					}
				}
			}
			count = min(count, 64 - count);
			ans = min(ans, count);
		}
	}
	cout << ans;
}
