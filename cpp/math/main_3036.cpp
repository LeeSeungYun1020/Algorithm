#include <iostream>
#include <algorithm>
#include <set>
#include <cmath>
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
	int first;
	cin >> first;
	int cmp;
	int g;
	for (int i = 1; i < count; ++i) {
		cin >> cmp;
		g = gcd(max(cmp, first), min(cmp, first));
		cout << first / g << '/' << cmp / g << '\n';
	}
}