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
	long long mx = 0;
	for (int i = 0; i < count; ++i) {
		cin >> input[i];
		mx = max(mx, static_cast<long long>(input[i]));
	}

	long long start = 1;
	long long end = mx;
	long long ans = 0;
	while (start <= end) {
		const long long mid = (start + end) / 2;
		long long sum = 0;
		for (auto value : input) {
			sum += max(value - mid, 0LL);
			if (sum >= limit) {
				break;
			}
		}
		if (sum < limit) {
			end = mid - 1;
		} else {
			ans = mid;
			start = mid + 1;
		}
	}
	cout << ans;
}
