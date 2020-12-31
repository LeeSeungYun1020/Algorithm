#include <iomanip>
#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	for (int i = count; i > 0; --i) {
		cout << string(i, '*') << endl;
	}
}
