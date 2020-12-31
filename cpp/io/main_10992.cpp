#include <iomanip>
#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	cout << string(count - 1, ' ') << '*' << endl;
	for (int i = 1; i < count - 1; ++i) {
		cout << setw(count - i) << '*' << string(2 * i - 1, ' ') << '*' << endl;
	}
	cout << string(2 * count - 1, '*') << endl;
}
