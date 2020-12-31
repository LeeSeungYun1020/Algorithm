#include <iomanip>
#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	for (int i = 0; i < count; ++i) {
		cout << setw(count + i) << string(2 * i + 1, '*') << endl;
	}
}
