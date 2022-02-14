#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int num;
	cin >> num;

	int* dp = new int[num + 1];
	dp[0] = 0;
	dp[1] = 1;
	for (int i = 2; i <= num; i++) {
		int s = static_cast<int>(sqrt(i));
		if (s * s == i) {
			dp[i] = 1;
		}
		else {
			dp[i] = dp[i - 1] + 1;
			for (int j = 2; j < s; ++j) {
				dp[i] = min(dp[i], dp[i - j * j] + 1);
			}
		}
	}
	cout << dp[num] << endl;
	delete[] dp;
}
