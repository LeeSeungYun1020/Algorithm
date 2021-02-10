#include <iostream>
using namespace std;

int exp(int a, int b, int c) {
	if (b == 0) {
		return 1;
	}
	if (b == 1) {
		return a % c;
	}
	const long long tem = exp(a, b / 2, c);
	const long long calc = tem * tem % c;
	if (b % 2 == 0) {
		return calc;
	} else {
		return calc * a % c;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int a, b, c;
	cin >> a >> b >> c;
	cout << exp(a, b, c);
}
