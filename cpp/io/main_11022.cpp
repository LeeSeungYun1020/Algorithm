#include <iostream>
#include <string>

using namespace std;

int main() {
	string line;
	getline(cin, line);
	int i = 1;
	while (getline(cin, line)) {
		const auto pos = line.find(' ');
		const auto a = stoi(line.substr(0, pos));
		const auto b = stoi(line.substr(pos + 1));
		cout << "Case #" << i << ": " << a << " + " << b << " = " << a + b << endl;
		i++;
	}
}
