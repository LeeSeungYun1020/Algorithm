#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;
	int* price = new int[count];
	for (int i = 0; i < count; ++i) {
		cin >> price[i];
	}

	int dp[1001] = {0, };
	for (int i = 1; i <= count; ++i) {
		for (int j = 0; j < i; ++j) {
			dp[i] = max(dp[i], dp[i - j - 1] + price[j]);
		}
	}

	cout << dp[count] << endl;
	delete[] price;
}
