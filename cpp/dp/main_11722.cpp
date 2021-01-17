#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int now[1000];
	int ans[1000] = {0, };
	int m = 1;
	for (int i = 0; i < count; ++i) {
		cin >> now[i];
		ans[i] = 1;
		for (int j = 0; j < i; ++j) {
			if (now[i] < now[j]) {
				ans[i] = max(ans[j] + 1, ans[i]);
			}
		}
		m = max(m, ans[i]);
	}
	cout << m << endl;
}