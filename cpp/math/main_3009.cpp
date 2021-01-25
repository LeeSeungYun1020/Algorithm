#include <iostream>

using namespace std;

int main() {
	int x[3];
	int y[3];
	for (int i = 0; i < 3; ++i) {
		cin >> x[i] >> y[i];
	}

	int ans[2];
	if (x[0] == x[1]) {
		ans[0] = x[2];
	} else if (x[1] == x[2]) {
		ans[0] = x[0];
	} else {
		ans[0] = x[1];
	}

	if (y[0] == y[1]) {
		ans[1] = y[2];
	} else if (y[1] == y[2]) {
		ans[1] = y[0];
	} else {
		ans[1] = y[1];
	}

	cout << ans[0] << ' ' << ans[1] << endl;
}