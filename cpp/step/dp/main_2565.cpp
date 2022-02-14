#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	vector<pair<int, int>> line;
	for (int i = 0; i < n; ++i) {
		int a, b;
		cin >> a >> b;
		line.push_back(make_pair(a, b));
	}
	sort(line.begin(), line.end());
	vector<int> ans;
	ans.push_back(line[0].second);
	for (int i = 1; i < n; ++i) {
		const int value = line[i].second;
		if (ans.back() < value) {
			ans.push_back(value);
		} else {
			int start = 0;
			int end = ans.size() - 1;
			while (start <= end) {
				const int mid = (start + end) / 2;
				if (ans[mid] > value) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			ans[start] = value;
		}
	}
	cout << n - ans.size();
}
