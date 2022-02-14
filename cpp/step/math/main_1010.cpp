#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int** dp = new int* [31];
	dp[1] = new int[1]{ 1 };
	for (int i = 2; i <= 30; ++i) {
		dp[i] = new int[i / 2 + 1]{ 1, };
		for (int j = 1; j <= i / 2; ++j) {
			dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][min(i - j - 1, j)];
		}
	}
	
	int count;
	cin >> count;
	for (int c = 0; c < count; ++c) {
		int n, k;
		cin >> k >> n;
		cout << dp[n][min(k, n - k)] << '\n';
	}
}