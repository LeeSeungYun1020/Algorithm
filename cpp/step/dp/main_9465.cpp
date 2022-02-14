#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int* table[2];
		int* calc[2];
		table[0] = new int [100001];
		table[1] = new int[100001];
		calc[0] = new int[100001];
		calc[1] = new int[100001];

	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		
		table[0][0] = 0;
		table[1][0] = 0;
		for (int j = 1; j <= num; ++j) {
			cin >> table[0][j];
		}
		for (int j = 1; j <= num; ++j) {
			cin >> table[1][j];
		}

		calc[0][0] = 0;
		calc[1][0] = 0;
		calc[0][1] = table[0][1];
		calc[1][1] = table[1][1];
		for (int i = 2; i <= num; ++i) {
			calc[0][i] = max(calc[1][i - 1], calc[1][i - 2]) + table[0][i];
			calc[1][i] = max(calc[0][i - 1], calc[0][i - 2]) + table[1][i];
		}
		cout << max(calc[0][num], calc[1][num]) << endl;
	}

	delete[] table[0];
	delete[] table[1];
	delete[] calc[0];
	delete[] calc[1];
}