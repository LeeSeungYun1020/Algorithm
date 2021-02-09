#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	int* road = new int[n - 1];
	for (int i = 0; i < n - 1; ++i) {
		cin >> road[i];
	}

	int minPrice;
	cin >> minPrice;
	long long distance = road[0];
	long long ans = 0;
	for (int i = 1; i < n - 1; ++i) {
		int tem;
		cin >> tem;
		if (tem < minPrice) {
			ans += (distance * minPrice);
			distance = 0;
			minPrice = tem;
		}
		distance += road[i];
	}
	ans += (distance * minPrice);
	cout << ans;
}
