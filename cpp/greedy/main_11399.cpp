#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	vector<int> table(n);
	for (int i = 0; i < n; ++i) {
		cin >> table[i];
	}
	sort(table.begin(), table.end());
	int ans = 0;
	int sum = 0;
	for (auto && value : table) {
		sum += value;
		ans += sum;
	}
	cout << ans;
}
