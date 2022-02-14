#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;

	int dp[15];
	dp[0] = 1;

	if (num % 2 == 1)
		cout << 0 << endl;
	else {
		for (int i = 1; i <= num / 2; ++i) {
			dp[i] = dp[i - 1];
			for (int j = 0; j < i; ++j) {
				dp[i] += 2 * dp[j];
			}
		}
		cout << dp[num / 2] << endl;
	}
}
