#include <iostream>
#include <cmath>
using namespace std;

int n;
int** arr;
bool* team;
int minValue = 5000;

void dfs(const int depth, const int start) {
	if (depth == n / 2) {
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (i != j) {
					if (team[i] && team[j]) {
						sum += (arr[i][j] + arr[j][i]);
					} else if (!team[i] && !team[j]) {
						sum -= (arr[i][j] + arr[j][i]);
					}
				}
			}
		}
		minValue = min(minValue, abs(sum));
	} else {
		for (int i = start; i < n; ++i) {
			if (!team[i]) {
				team[i] = true;
				dfs(depth + 1, i + 1);
				team[i] = false;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	team = new bool[n] {false, };
	arr = new int* [n];
	for (int i = 0; i < n; ++i) {
		arr[i] = new int[n];
		for (int j = 0; j < n; ++j) {
			cin >>arr[i][j];
		}
	}
	dfs(0, 0);
	cout << minValue;
}
