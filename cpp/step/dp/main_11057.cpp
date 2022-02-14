#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;
	
	int check[2][10] = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, } };
	for (int i = 1; i < num; ++i) {
		int prev = (i + 1) % 2;
		int now = i % 2;
		check[now][0] = check[prev][0];
		for (int j = 1; j < 10; ++j) {
			check[now][j] = (check[now][j - 1] + check[prev][j]) % 10007;
		}
	}
	
	int ans = 0;
	for (int i = 0; i < 10; ++i) {
		ans = (ans + check[(num + 1) % 2][i]) % 10007;
	}
	cout << ans << endl;
}
