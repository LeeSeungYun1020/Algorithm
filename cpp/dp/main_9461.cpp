#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	int dp[101];
	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	for (int i = 5; i <= 100; ++i) {
		dp[i] = dp[i - 5] + dp[i - 1];
	}
	
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		cout << dp[num] << endl;
	}
}