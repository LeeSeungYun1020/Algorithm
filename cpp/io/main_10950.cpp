#include <iostream>

using namespace std;

int main()
{
	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int a, b;
		cin >> a >> b;
		cout << a + b << endl;
	}
}