#include <iostream>
#include <vector>

using namespace std;

int main() {
	vector<bool> pn(10001, true);
	pn[0] = false;
	pn[1] = false;
	for (int i = 2; i <= 100; ++i) {
		if (pn[i]) {
			for (int j = 2; j <= 10000 / i; ++j) {
				pn[i * j] = false;
			}
		}
	}

	int cnt;
	cin >> cnt;
	for (int i = 0; i < cnt; ++i) {
		int num;
		cin >> num;
		for (int j = num/2; j < num; ++j) {
			if (pn[j] && pn[num - j]) {
				cout << num - j << ' ' << j << endl;
				break;
			}
		}
	}
}
