#include <iostream>

using namespace std;

int main() {
	int n, k;
	cin >> n >> k;

	int dp[201][201];
	dp[0][0] = 0;
	for (int i = 0; i <= n; ++i) {
		dp[0][i] = 1;
	}
	for (int i = 1; i < k; ++i) {
		for (int j = 0; j <= n; ++j) {
			dp[i][j] = 0;
			for (int l = 0; l <= j; ++l) {
				dp[i][j] = (dp[i][j] + dp[i - 1][l]) % 1000000000;
			}
		}
	}
	cout << dp[k - 1][n] << endl;
}