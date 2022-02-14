#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int count;
	cin >> count;
	int* num = new int[count];
	for (int i = 0; i < count; ++i) {
		cin >> num[i];
	}
	sort(num, num + count);
	cout << num[0] * num[count - 1] << '\n';
	delete[] num;
}