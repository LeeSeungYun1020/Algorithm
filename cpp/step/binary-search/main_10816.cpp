#include <iostream>
#include <map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int count;
	cin >> count;
	map<int, int> input;
	for (int i = 0; i < count; ++i) {
		int t;
		cin >> t;
		input[t] += 1;
	}
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int t;
		cin >> t;
		cout << input[t] << ' ';
	}
}
