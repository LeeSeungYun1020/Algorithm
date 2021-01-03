#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;

	int a = 0;
	int b = 1;
	for (int i = 0; i < num; ++i) {
		int tem = a;
		a = b;
		b = (tem + b) % 10007;
	}
	cout << b << endl;
}
