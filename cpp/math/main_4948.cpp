#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	vector<bool> pn(246913, true);
	pn[0] = false;
	pn[1] = false;
	for (int i = 2; i < 497; ++i) {
		if (pn[i]) {
			for (int j = 2; j <= 246912 / i; ++j) {
				pn[i * j] = false;
			}
		}
	}
	while (true) {
		int num;
		cin >> num;
		if (num == 0) break;
		cout << count(pn.begin() + num + 1, pn.begin() + num * 2 + 1, true) << endl;
	}
}
