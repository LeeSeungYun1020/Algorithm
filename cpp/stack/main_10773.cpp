#include <iostream>
#include <stack>
using namespace std;

int main() {
	int count;
	cin >> count;
	stack<int> stk;
	int sum = 0;
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		if (num == 0) {
			sum -= stk.top();
			stk.pop();
		} else {
			sum += num;
			stk.push(num);
		}
	}
	cout << sum << '\n';
}