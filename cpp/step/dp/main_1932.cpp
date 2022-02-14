#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;

	int** dp = new int*[n];
	dp[0] = new int;
	cin >> dp[0][0];
	int mx = dp[0][0];
	for (int i = 1; i < n; ++i) {
		dp[i] = new int[i + 1];
		cin >> dp[i][0];
		dp[i][0] += dp[i - 1][0];
		if (i == n - 1) {
			mx = dp[i][0];
		}
		for (int j = 1; j < i; ++j) {
			cin >> dp[i][j];
			dp[i][j] += max(dp[i - 1][j - 1], dp[i - 1][j]);
			if (i == n - 1 && dp[i][j] > mx) {
				mx = dp[i][j];
			}
		}
		cin >> dp[i][i];
		dp[i][i] += dp[i - 1][i - 1];
		if (i == n - 1 && dp[i][i] > mx) {
			mx = dp[i][i];
		}
	}
	cout << mx;
}
