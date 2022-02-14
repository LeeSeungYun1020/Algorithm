#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	vector<pair<int, int>> table(n);
	for (int i = 0; i < n; ++i) {
		cin >> table[i].first >> table[i].second;
	}
	sort(table.begin(), table.end(), [](pair<int, int> p1, pair<int, int> p2) {
		if (p1.second == p2.second) {
			return p1.first < p2.first;
		}
		return p1.second < p2.second;
	});

	int ans = 0;
	int fin = 0;
	for (auto && value : table) {
		if (value.first >= fin) {
			fin = value.second;
			ans++;
		}
	}
	cout << ans;
}
