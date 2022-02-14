#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count, limit;
	cin >> count >> limit;
	vector<int> input(count);
	for (int i = 0; i < count; ++i) {
		cin >> input[i];
	}
	sort(input.begin(), input.end());

	long long start = 1;
	long long end = input.back() - input.front();
	long long ans = 0;
	while (start <= end) {
		const long long mid = (start + end) / 2;
		int c = 1;
		int pos = input[0];
		for (auto value : input) {
			if (value - pos >= mid) {
				pos = value;
				c++;
			}
		}
		if (c < limit) {
			end = mid - 1;
		} else {
			ans = mid;
			start = mid + 1;
		}
	}
	cout << ans;
}
