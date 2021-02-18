#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count;
	cin >> count;
	vector<int> input(count);
	for (int i = 0; i < count; ++i) {
		cin >> input[i];
	}
	sort(input.begin(), input.end());
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int t;
		cin >> t;
		cout << binary_search(input.begin(), input.end(), t) << '\n';
	}
}
