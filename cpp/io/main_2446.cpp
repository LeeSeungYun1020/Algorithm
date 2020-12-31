#include <iomanip>
#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	for (int i = count; i > 0; --i) {
		cout << setw(count + i - 1) << string(2 * i - 1, '*') << endl;
	}
	for (int i = 2; i <= count; ++i) {
		cout << setw(count + i - 1) << string(2 * i - 1, '*') << endl;
	}
}
