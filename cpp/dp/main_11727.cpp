#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;
	if (num == 1) {
		cout << 1 << endl;
		return 0;
	}
	int a = 1;
	int b = 3;
	for (int i = 2; i < num; ++i) {
		int tem = a;
		a = b;
		b = (2 * tem + b) % 10007;
	}
	cout << b << endl;
}
