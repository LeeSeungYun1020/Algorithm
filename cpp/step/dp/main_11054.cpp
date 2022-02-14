#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int now[1000];
	int up[1000] = {0, };
	int down[1000] = { 0, };
	
	for (int i = 0; i < count; ++i) {
		cin >> now[i];
		up[i] = 1;
		for (int j = 0; j < i; ++j) {
			if (now[i] > now[j]) {
				up[i] = max(up[j] + 1, up[i]);
			}
		}
	}
	
	int m = 1;
	for (int i = count - 1; i >= 0; --i) {
		for (int j = count - 1; j > i; --j) {
			if (now[i] > now[j]) {
				down[i] = max(down[j] + 1, down[i]);
			}
		}
		m = max(m, up[i] + down[i]);
	}
	
	cout << m << endl;
}