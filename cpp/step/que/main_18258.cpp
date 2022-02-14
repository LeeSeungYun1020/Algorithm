#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int count;
	cin >> count;

	string command;
	int* que = new int[count];
	int start = 0;
	int end = 0;
	int num;
	for (int i = 0; i < count; ++i) {
		cin >> command;
		if (command == "push") {
			cin >> num;
			que[end++] = num;
		} else if (command == "pop") {
			if (start == end) {
				cout << -1 << '\n';
			} else {
				cout << que[start++] << '\n';
			}
		} else if (command == "size") {
			cout << end - start << '\n';
		} else if (command == "empty") {
			cout << (end - start == 0) << '\n';
		} else if (command == "front") {
			if (start == end) {
				cout << -1 << '\n';
			} else {
				cout << que[start] << '\n';
			}			
		} else if (command == "back") {
			if (start == end) {
				cout << -1 << '\n';
			} else {
				cout << que[end - 1] << '\n';
			}
		}
	}
	delete[] que;
}