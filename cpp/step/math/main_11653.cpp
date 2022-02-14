#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int num;
	cin >> num;

	for (int i = 2; i <= sqrt(num); ++i) {
		if (num % i == 0) {
			cout << i << endl;
			num /= i;
			i--;
		}
	}
	if (num != 1) {
		cout << num << endl;
	}
}
