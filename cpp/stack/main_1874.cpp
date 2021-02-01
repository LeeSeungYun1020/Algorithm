#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
	int count;
	cin >> count;
	
	stack<int> stk;
	vector<char> ans;
	int value = 1;
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		if (value <= num) {
			for (int j = value; j <= num; ++j) {
				stk.push(value++);
				ans.push_back('+');
			}
			stk.pop();
			ans.push_back('-');
		} else {
			if (stk.top() == num) {
				stk.pop();
				ans.push_back('-');
			} else {
				break;
			}
		}
	}
	if (stk.empty()) {
		for (auto&& a : ans)
			cout << a << '\n';
	} else {
		cout << "NO\n";
	}
}