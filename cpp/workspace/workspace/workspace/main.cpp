#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	if (n == 1) {
		cout << 666;
		return 0;
	}
	int i = 1665;
	while (n > 1) {
		i++;
		if (to_string(i).find("666") != string::npos) {
			n--;
		}
	}
	cout << i;
}
