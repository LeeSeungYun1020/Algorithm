#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
    string num;
	cin >> num;
	sort(num.rbegin(), num.rend());
	cout << num;
}