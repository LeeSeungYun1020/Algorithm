#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int dp[301] = {0,};
	int num[301] = {0,};

	cin >> num[1];
	dp[1] = num[1];
	if (count > 1) {
		cin >> num[2];
		dp[2] = dp[1] + num[2];
	}
	for (int i = 3; i <= count; ++i) {
		cin >> num[i];
		dp[i] = max(dp[i - 3] + num[i - 1] + num[i], dp[i - 2] + num[i]);
	}
	cout << dp[count] << endl;
}
