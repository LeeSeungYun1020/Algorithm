#include <iostream>
#include <cmath>
using namespace std;

long long area;
int arr[100000];

void find(const int start, const int end) {
	if (start > end) {
		return;
	}
	if (start == end) {
		area = max(area, static_cast<long long>(arr[start]));
		return;
	}

	const int mid = (start + end) / 2;
	find(start, mid);
	find(mid + 1, end);


	int low = mid;
	int high = mid + 1;
	int height = min(arr[low], arr[high]);
	area = max(area, static_cast<long long>(height) * 2);
	while (start < low && high < end) {
		if (low <= start) {
			height = min(height, arr[++high]);
		} else if (high >= end) {
			height = min(height, arr[--low]);
		} else if (arr[high + 1] > arr[low - 1]) {
			height = min(height, arr[++high]);
		} else {
			height = min(height, arr[--low]);
		}
		area = max(area, height * (static_cast<long long>(high) - low + 1));
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int num;
	while (true) {
		area = 0;
		cin >> num;
		if (num == 0) {
			return 0;
		}
		for (int i = 0; i < num; ++i) {
			cin >> arr[i];
		}
		find(0, num - 1);
		cout << area << '\n';
	}
}
