#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;
	long long zero = 1;
	long long one = 0;
	for (int i = 2; i < num; ++i) {
		const auto tem = one;
		one = zero;
		zero = tem + zero;
	}
	cout << zero + one << endl;
}
