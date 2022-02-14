#include <iostream>
#include <string>

using namespace std;

int main()
{
	string line;
	getline(cin, line);
	while (getline(cin, line)) {
		const auto pos = line.find(',');
		cout << stoi(line.substr(0, pos)) + stoi(line.substr(pos + 1)) << endl;
	}
}