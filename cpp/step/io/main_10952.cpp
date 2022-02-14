#include <iostream>
#include <string>

using namespace std;

int main()
{
	string line;
	while (getline(cin, line)) {
		const auto pos = line.find(' ');
		const int a = stoi(line.substr(0, pos));
		const int b = stoi(line.substr(pos + 1));
		if (a == 0 && b == 0) {
			break;
		}
		cout << a + b << endl;
	}
}