#include <iostream>

using namespace std;

void check(int max, int a, int b) {
	if (pow(max, 2) == pow(a, 2) + pow(b, 2)) {
		cout << "right" << endl;
	} else {
		cout << "wrong" << endl;
	}
}

int main() {
	while (true) {
		int len[3];
		cin >> len[0] >> len[1] >> len[2];

		if (len[0] == 0 && len[1] == 0 && len[2] == 0) {
			break;
		}
		if (len[0] > len[1]) {
			if (len[0] > len[2]) {
				check(len[0], len[1], len[2]);
			} else {
				check(len[2], len[1], len[0]);
			}
		} else {
			if (len[1] > len[2]) {
				check(len[1], len[0], len[2]);
			} else {
				check(len[2], len[1], len[0]);
			}
		}
	}
}