#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		int sum = i;
		int j = i;
		while (j > 0) {
			sum += (j % 10);
			j /= 10;
		}
		if (sum == n) {
			cout << i;
			return 0;
		}
	}
	cout << 0;
}
