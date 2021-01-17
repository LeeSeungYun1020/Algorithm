#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int dp[100000];
	int m;

	cin >> dp[0];
	m = dp[0];
	for (int i = 1; i < count; ++i) {
		int now;
		cin >> now;
		dp[i] = max(dp[i - 1] + now, now);
		m = max(m, dp[i]);
	}
	cout << m << endl;
}