#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	while (true) {
		string line;
		getline(cin, line);
		if (line == ".") {
			break;
		}
		
		stack<char> stk;
		bool isPass = true;
		for (auto && c : line)  {
			if (c == '(' || c == '[') {
				stk.push(c);
			}
			if (c == ')') {
				if (!stk.empty() && stk.top() == '(') {
					stk.pop();
				} else {
					isPass = false;
					break;
				}
			}
			if (c == ']') {
				if (!stk.empty() && stk.top() == '[') {
					stk.pop();
				} else {
					isPass = false;
					break;
				}
			}
		}

		if (isPass && stk.empty()) {
			cout << "yes" << '\n';
		} else {
			cout << "no" << '\n';
		}
	}
}