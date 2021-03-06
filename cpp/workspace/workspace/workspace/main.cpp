#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;
	int** array = new int*[n + 1];
	array[0] = new int[k + 1]{0,};
	for (int i = 1; i <= n; ++i) {
		array[i] = new int[k + 1];
		array[i][0] = 0;
		int weight, value;
		cin >> weight >> value;
		for (int j = 1; j <= k; ++j) {
			if (j < weight) {
				array[i][j] = array[i - 1][j];
			} else {
				array[i][j] = max(array[i - 1][j - weight] + value, array[i - 1][j]);
			}
		}
	}
	cout << array[n][k];
}
