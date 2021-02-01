#include <iostream>
#include <stack>
#include <vector>
#include <utility>

using namespace std;

int main() {
	int count;
	cin >> count;
	
	stack<pair<int, int>> stk;
	vector<int> ans(count, -1);
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		while (!stk.empty() && stk.top().second < num) {
			ans[stk.top().first] = num;
			stk.pop();
		}
		stk.push(make_pair(i, num));
	}
	
	for (auto&& a : ans)
		cout << a << ' ';
}