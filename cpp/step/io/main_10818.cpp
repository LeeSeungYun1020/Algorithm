#include <iostream>

using namespace std;

int main() {
	int count;
	cin >> count;

	int tem, min = 1000000, max = -1000000;
	for (int i = 0; i < count; ++i) {
		cin >> tem;
		if (min > tem) {
			min = tem;
		}
		if (max < tem) {
			max = tem;
		}
	}
	cout << min << " " << max << endl;
}
