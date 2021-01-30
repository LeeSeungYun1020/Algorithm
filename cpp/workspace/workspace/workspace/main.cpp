#include <iostream>
using namespace std;

long long countMult(const int num, const int m) {
	long long ans = 0;
	for (long long i = m; i <= num; i *= m) {
		ans += (num / i);
	}
	return ans;
}

int main() {
	int n, m;
	cin >> n >> m;
	const long long five = countMult(n, 5) - countMult(n - m, 5) - countMult(m, 5);
	const long long two = countMult(n, 2) - countMult(n - m, 2) - countMult(m, 2);
	cout << min(five, two) << '\n';
}