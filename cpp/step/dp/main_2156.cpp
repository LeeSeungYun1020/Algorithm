#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int count;
	cin >> count;

	int sum[10001] = {0, };
	int val[10001] = {0, };
	
	
	cin >> val[1];
	sum[1] = val[1];

	if (count > 1) {
		cin >> val[2];
	}
	sum[2] = val[1] + val[2];
	
	for(int i = 3; i <= count; ++i) {
		cin >> val[i];
		sum[i] = max(sum[i - 2] + val[i], sum[i - 3] + val[i - 1] + val[i]);
		sum[i] = max(sum[i], sum[i - 1]);
	}
	cout << sum[count] << endl;
}