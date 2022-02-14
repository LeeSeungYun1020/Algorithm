#include <iostream>
using namespace std;

const int MOD = 1000000007;

long long power(long long n, int k) {
	if (k == 0) {
		return 1;
	}
	if (k == 1) {
		return n;
	}

	const long long calc = power(n * n % MOD, k / 2);
	if (k % 2 == 0) {
		return calc;
	}
	return calc * n % MOD;
}

int* calcFactorial(int n) {
	int* factorial = new int[n + 1]{0, 1, 2};
	for (long long i = 3; i <= n; ++i) {
		factorial[i] = factorial[i - 1] * i % MOD;
	}
	return factorial;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int n, k;
	cin >> n >> k;
	if (k == 0) {
		cout << 1;
	} else if (k == 1) {
		cout << n;
	} else {
		const int* const factorial = calcFactorial(n);
		cout << factorial[n] * power(factorial[n - k], MOD - 2) % MOD * power(factorial[k], MOD - 2) % MOD;
		delete[] factorial;
	}
}
