#include <iostream>
#include <vector>

using namespace std;

int main() {
	bool pn[1001];
	fill_n(pn, 1000, true);
	pn[0] = false;
	pn[1] = false;
	for (int i = 2; i < 32; ++i) {
		for (int j = 2, k = i * j; k < 1000; j++, k = i * j) {
			pn[k] = false;
		}
	}
	
	int count;
	cin >> count;

	int ans = 0;
	for (int i = 0; i < count; ++i) {
		int tem;
		cin >> tem;
		if (pn[tem]) {
			ans++;
		}
	}
	cout << ans << endl;
}
