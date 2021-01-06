#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;
	
	int check[2][10] = { {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, } };
	for (int i = 1; i < num; ++i) {
		int prev = (i + 1) % 2;
		int now = i % 2;
		check[now][0] = check[prev][1];
		for (int j = 1; j < 9; ++j) {
			check[now][j] = (check[prev][j - 1] + check[prev][j + 1]) % 1000000000;
		}
		check[now][9] = check[prev][8];
	}
	
	long long ans = 0;
	for (int i = 0; i < 10; ++i) {
		ans = (ans + check[(num + 1) % 2][i]) % 1000000000;
	}
	cout << ans << endl;
}
