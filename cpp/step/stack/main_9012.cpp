#include <iostream>
using namespace std;

int main() {
	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		string line;
		cin >> line;

		int check = 0;
		for (auto && c : line) {
			if (c == '(') {
				check++;
			}
			if (c == ')') {
				check--;
			}
			if (check < 0) {
				break;
			}
		}
		if (check == 0) {
			cout << "YES" << '\n';
		} else {
			cout << "NO" << '\n';
		}
	}
}