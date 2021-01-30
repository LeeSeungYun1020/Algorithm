#include <iostream>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;

	int up = 1;
	int down = 1;
	for (int i = 2; i <= n; ++i) {
		if (i > n - k) {
			up *= i;
		}
		if (i <= k) {
			down *= i;
		}
	}
	cout << up / down << '\n';
}