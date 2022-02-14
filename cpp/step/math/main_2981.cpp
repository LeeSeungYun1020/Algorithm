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
	int* num = new int[count];
	for (int i = 0; i < count; ++i) {
		cin >> num[i];
	}
	sort(num, num + count);
	int ans = num[1] - num[0];
	for (int i = 2; i < count; ++i) {
		ans = gcd(ans, num[i] - num[i - 1]);
	}
	set<int> ansSet;
	ansSet.insert(ans);
	for (int i = 2; i <= sqrt(ans); ++i) {
		if (ans % i == 0) {
			ansSet.insert(i);
			ansSet.insert(ans / i);
		}
	}
	for (auto && value : ansSet) {
		cout << value << ' ';
	}
}