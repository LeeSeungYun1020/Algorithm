#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;

	int start = 1;
	int end = k;
	int ans = 0;
	while (start <= end) {
		const int mid = (start + end) / 2;
		int sum = 0;
		for (int i = 1; i <= n; ++i) {
			sum += min(mid / i, n);
		}
		if (sum < k) {
			start = mid + 1;
		} else {
			ans = mid;
			end = mid - 1;
		}
	}
	cout << ans;
}
