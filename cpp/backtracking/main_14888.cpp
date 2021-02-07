#include <iostream>
#include <cmath>
using namespace std;

int n;
int arr[11];
int operation[4];
int minValue = 1000000000;
int maxValue = -1000000000;

void dfs(int depth, int calc) {
	if (depth == n) {
		minValue = min(minValue, calc);
		maxValue = max(maxValue, calc);
	} else {
		for (int i = 0; i < 4; ++i) {
			if (operation[i] > 0) {
				operation[i]--;
				int tem = calc;
				if (i == 0) {
					tem += arr[depth];
				} else if (i == 1) {
					tem -= arr[depth];
				} else if (i == 2) {
					tem *= arr[depth];
				} else {
					tem /= arr[depth];
				}
				dfs(depth + 1, tem);
				operation[i]++;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
	}
	for (int& op : operation) {
		cin >> op;
	}
	dfs(1, arr[0]);
	cout << maxValue << '\n' << minValue;
}
