#include <iostream>
#include <stack>
using namespace std;

int main() {
	int count;
	cin >> count;
	stack<int> stk;
	for (int i = 0; i < count; ++i) {
		string command;
		cin >> command;
		if (command == "push") {
			int num;
			cin >> num;
			stk.push(num);
		} else if (command == "pop") {
			if (stk.empty()) {
				cout << -1 << '\n';
			} else {
				cout << stk.top() << '\n';
				stk.pop();
			}
		} else if (command == "size") {
			cout << stk.size() << '\n';
		} else if (command == "empty") {
			cout << stk.empty() << '\n';
		} else if (command == "top") {
			if (stk.empty()) {
				cout << -1 << '\n';
			} else {
				cout << stk.top() << '\n';
			}
		}
	}
}