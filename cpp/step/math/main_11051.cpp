#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	int** dp = new int*[n + 1];
	dp[1] = new int[1]{ 1 };
	for (int i = 2; i <= n; ++i) {
		dp[i] = new int[i / 2 + 1]{ 1, };
		for (int j = 1; j <= i / 2; ++j) {
			dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][min(i - j - 1, j)]) % 10007;
		}
	}
	cout << dp[n][min(k, n - k)] << '\n';
}