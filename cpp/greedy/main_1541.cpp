#include <iostream>
#include <string>
using namespace std;

int calcAdd(const string& calc) {
	int ans = 0;
	int start = 0;
	while (true) {
		const int end = calc.find('+', start);
		ans += stoi(calc.substr(start, end - start));
		start = end + 1;
		if (end == string::npos) {
			break;
		}
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	
	string s;
	cin >> s;
	
	int start = s.find('-');
	int ans;
	if (start == string::npos) {
		ans = calcAdd(s);
	} else {
		ans = calcAdd(s.substr(0, start++));
		while (true) {
			const int end = s.find('-', start);
			ans -= calcAdd(s.substr(start, end - start));
			start = end + 1;
			if (end == string::npos) {
				break;
			}
		}
	}
	cout << ans;
}
