#include <iostream>
#include <deque>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int count;
	cin >> count;
	deque<int> deq;
	for (int i = 0; i < count; ++i) {
		string command;
		cin >> command;

		int num;
		if (command == "push_front") {
			cin >> num;
			deq.push_front(num);
		} else if (command == "push_back") {
			cin >> num;
			deq.push_back(num);
		} else if (command == "pop_front") {
			if (deq.empty()) {
				cout << -1 << '\n';
			} else {
				cout << deq.front() << '\n';
				deq.pop_front();
			}
		} else if (command == "pop_back") {
			if (deq.empty()) {
				cout << -1 << '\n';
			} else {
				cout << deq.back() << '\n';
				deq.pop_back();
			}
		} else if (command == "size") {
			cout << deq.size() << '\n';
		} else if (command == "empty") {
			cout << deq.empty() << '\n';
		} else if (command == "front") {
			if (deq.empty()) {
				cout << -1 << '\n';
			} else {
				cout << deq.front() << '\n';
			}
		} else if (command == "back") {
			if (deq.empty()) {
				cout << -1 << '\n';
			} else {
				cout << deq.back() << '\n';
			}
		}
	}
}
