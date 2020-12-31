#include <iomanip>
#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	for (int i = 1; i <= count; ++i) {
		cout << setw(count) << string(i, '*') << endl;
	}
	for (int i = count - 1; i > 0; --i) {
		cout << setw(count) << string(i, '*') << endl;
	}
}
