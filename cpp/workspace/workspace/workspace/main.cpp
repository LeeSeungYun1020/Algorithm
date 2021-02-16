#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int, int>> point;

int calcDistance(const int start, const int end) {
	if (start == end) {
		return 30000;
	}
	if (start == end - 1) {
		int dx = point[start].first - point[end].first;
		int dy = point[start].second - point[end].second;
		return dx * dx + dy * dy;
	}
	const int mid = (start + end) / 2;
	int distance = min(calcDistance(start, mid), calcDistance(mid + 1, end));
	const int line = point[mid].first;
	vector<pair<int, int>> cmp;
	for (int i = start; i <= end; ++i) {
		const int d = point[i].first - line;
		if (d * d < distance) {
			cmp.push_back(point[i]);
		}
	}
	sort(cmp.begin(), cmp.end(), [&](pair<int, int>& a, pair<int, int>& b) { return a.second < b.second; });

	for (int i = 0; i < static_cast<int>(cmp.size()) - 1; ++i) {
		for (int j = i + 1; j < cmp.size(); ++j) {
			const int dy = cmp[i].second - cmp[j].second;
			if (dy * dy >= distance) break;
			const int dx = cmp[i].first - cmp[j].first;
			distance = min(distance, dx * dx + dy * dy);
		}
	}
	return distance;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int count;
	cin >> count;
	int x, y;
	for (int i = 0; i < count; ++i) {
		cin >> x >> y;
		point.push_back(make_pair(x, y));
	}
	sort(point.begin(), point.end(), [&](pair<int, int>& a, pair<int, int>& b) { return a.first < b.first; });
	cout << calcDistance(0, count - 1);
}
