#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {
	int r;
	cin >> r;

	cout.setf(ios::fixed);
	cout.precision(6);
	cout << acos(-1) * r * r << endl;
	cout << 2.0 * r * r << endl;
}