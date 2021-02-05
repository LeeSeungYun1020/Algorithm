#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	vector<pair<int, int>> people(n);
	for (int i = 0; i < n; ++i) {
		int x, y;
		cin >> x >> y;
		people[i] = make_pair(x, y);
	}

	for (int i = 0; i < n; ++i) {
		int count = 0;
		for (int j = 0; j < n; ++j) {
			if (people[i].first < people[j].first && people[i].second < people[j].second) {
				count++;
			}
		}
		cout << count + 1 << '\n';
	}
}
