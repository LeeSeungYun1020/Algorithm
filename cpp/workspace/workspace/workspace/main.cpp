#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count, limit;
	cin >> count >> limit;
	vector<int> input(count);
	int mx = 0;
	for (int i = 0; i < count; ++i) {
		cin >> input[i];
		mx = max(mx, input[i]);
	}

	long long start = 1;
	long long end = mx;
	int ans = 0;
	while (start <= end) {
		const long long mid = (static_cast<long long>(start) + end) / 2;
		if (mid == 0) {
			break;
		}
		long long sum = 0;
		for (auto value : input) {
			sum += (value / mid);
		}
		if (sum < limit) {
			end = mid - 1;
		} else {
			if (ans < mid) {
				ans = mid;
			}
			start = mid + 1;
		}
	}
	cout << ans;
}
