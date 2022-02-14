#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b) {
	const int cmp = a % b;
	if (cmp == 0) {
		return b;
	}
	return gcd(b, cmp);
}

int main() {
	int count;
	cin >> count;
	int a, b;
	for (int i = 0; i < count; ++i) {
		cin >> a >> b;
		cout << a / gcd(max(a, b), min(a, b)) * b << '\n';
	}
}