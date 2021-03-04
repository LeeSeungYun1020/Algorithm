#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int zero[41] = {1,};
	int one[41] = {0, 1,};
	for (int i = 2; i <= 40; ++i) {
		zero[i] = zero[i - 1] + zero[i - 2];
		one[i] = one[i - 1] + one[i - 2];
	}
	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		cout << zero[num] << ' ' << one[num] << '\n';
	}
}
