#include <iostream>
#include <string>
using namespace std;

string* arr;

string cut(pair<int, int> start, int length) {
	const char standard = arr[start.first][start.second];
	if (length == 1) {
		if (standard == '0') {
			return "0";
		} else {
			return "1";
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
			if (standard == '0') {
				return "0";
			} else {
				return "1";
			}
		} else {
			const int len = length / 2;
			string str = "(";
			str.append(cut(start, len));
			str.append(cut(make_pair(start.first, start.second + len), len));
			str.append(cut(make_pair(start.first + len, start.second), len));
			str.append(cut(make_pair(start.first + len, start.second + len), len));
			return str + ")";
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	arr = new string [n];
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
	}
	cout << cut(make_pair(0, 0), n);
}
