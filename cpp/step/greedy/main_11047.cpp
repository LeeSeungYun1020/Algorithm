#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, k;
	stack<int> stk;

	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		int tem;
		cin >> tem;
		if (tem > k) {
			break;
		}
		stk.push(tem);
	}

	int count = 0;
	while (k > 0) {
		if (k >= stk.top()) {
			k -= stk.top();
			count++;
		} else {
			stk.pop();
		}
	}
	cout << count;
}
