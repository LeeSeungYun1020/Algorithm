#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int array[21][21][21] = {{{1,},},};
	for (int i = 0; i < 21; ++i) {
		for (int j = 0; j < 21; ++j) {
			for (int k = 0; k < 21; ++k) {
				if (i == 0 || j == 0 || k == 0) {
					array[i][j][k] = 1;
				} else if (i < j && j < k) {
					array[i][j][k] = array[i][j][k - 1] + array[i][j - 1][k - 1] - array[i][j - 1][k];
				} else {
					array[i][j][k] = array[i - 1][j][k] + array[i - 1][j - 1][k]
						+ array[i - 1][j][k - 1] - array[i - 1][j - 1][k - 1];
				}
			}
		}
	}
	while (true) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1) {
			return 0;
		}
		cout << "w(" << a << ", " << b << ", " << c << ") = ";
		if (a <= 0 || b <= 0 || c <= 0) {
			cout << 1 << '\n';
		} else if (a > 20 || b > 20 || c > 20) {
			cout << 1048576 << '\n';
		} else {
			cout << array[a][b][c] << '\n';
		}
	}
}
