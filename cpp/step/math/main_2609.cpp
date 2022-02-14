#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	int gcd = 1;
	for (int i = 2; i <= min(a, b);) {
		if (a % i == 0 && b % i == 0) {
			a /= i;
			b /= i;
			gcd *= i;
		} else
			i++;
	}
	cout << gcd << '\n' << gcd * a * b << '\n';
}