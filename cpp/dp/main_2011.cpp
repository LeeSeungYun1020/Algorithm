#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;
	cin >> str;
	const int len = str.length();
	
	if (len < 1 || str.at(0) == '0') {
		cout << 0 << endl;
		return 0;
	}
	int dp[5001] = {1, 1, 0, };

	if (len > 1) {
		const int tem = stoi(str.substr(0, 2));
		if (tem % 10 == 0) {
			dp[1] = 0;
		}
		if (tem == 10 || tem == 20) {
			dp[1] = 1;
		}
		else if (tem <= 26) {
			dp[1] = 2;
		}
	}
	
	for (int i = 2; i < len; ++i) {
		const char now = str.at(i);
		const int ten = stoi(str.substr(i - 1, 2));
		if (ten == 0) {
			cout << 0 << endl;
			return 0;
		}
		if ('0' < now && now <= '9') {
			dp[i] = (dp[i] + dp[i - 1]) % 1000000;
		}
		if (9 < ten && ten <= 26) {
			dp[i] = (dp[i] + dp[i - 2]) % 1000000;
		}
	}

	cout << dp[len - 1] << endl;
}