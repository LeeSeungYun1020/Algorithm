#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	int* array = new int[max(2, n)]{1, 2};
	for (int i = 2; i < n; ++i) {
		array[i] = (array[i - 2] + array[i - 1]) % 15746;
	}
	cout << array[n - 1];
	delete[] array;
}
