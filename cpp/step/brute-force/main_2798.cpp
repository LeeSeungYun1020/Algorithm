#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
	cin >> n >> m;

	vector<int> num(n);
	for (int i = 0; i < n; ++i) {
		cin >> num[i];
	}

	int ans = 0;
	for (int i = 0; i < n - 2; ++i) {
		for (int j = i + 1; j < n - 1; ++j) {
			for (int k = j + 1; k < n; ++k) {
				const int sum = num[i] + num[j] + num[k];
				if (sum <= m && m - ans > m - sum) {
					ans = sum;
				}
			}
		}
	}
	cout << ans;
}
