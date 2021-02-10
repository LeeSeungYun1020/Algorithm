#include <iostream>
using namespace std;

int** arr;
int zCount = 0;
int oCount = 0;

void cut(pair<int, int> start, int length) {
	const int standard = arr[start.first][start.second];
	if (length == 1) {
		if (standard == 0) {
			zCount++;
		} else {
			oCount++;
		}
	} else {
		bool pass = true;
		for (int i = start.first; i < start.first + length; ++i) {
			for (int j = start.second; j < start.second + length; ++j) {
				if (standard != arr[i][j]) {
					pass = false;
					break;
				}
			}
			if (!pass) {
				break;
			}
		}
		if (pass) {
			if (standard == 0) {
				zCount++;
			} else {
				oCount++;
			}
		} else {
			const int len = length / 2;
			cut(start, len);
			cut(make_pair(start.first, start.second + len), len);
			cut(make_pair(start.first + len, start.second), len);
			cut(make_pair(start.first + len, start.second + len), len);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	arr = new int* [n];
	for (int i = 0; i < n; ++i) {
		arr[i] = new int[n];
		for (int j = 0; j < n; ++j) {
			cin >> arr[i][j];
		}
	}
	cut(make_pair(0, 0), n);
	cout << zCount << '\n' << oCount;
}
