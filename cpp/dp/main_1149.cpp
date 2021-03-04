#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int house;
	cin >> house;
	int dp[3];
	cin >> dp[0] >> dp[1] >> dp[2];
	for (int i = 1; i < house; ++i) {
		int r, g, b;
		cin >> r >> g >> b;
		const int dpR = min(dp[1], dp[2]) + r;
		const int dpG = min(dp[0], dp[2]) + g;
		const int dpB = min(dp[0], dp[1]) + b;
		dp[0] = dpR;
		dp[1] = dpG;
		dp[2] = dpB;
	}
	cout << min(dp[0], min(dp[1], dp[2]));
}
