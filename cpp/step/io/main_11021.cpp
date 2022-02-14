#include <iostream>
#include <string>

using namespace std;

int main()
{
	string line;
	getline(cin, line);
	int i = 0;
	while (getline(cin, line)) {
		i++;
		const auto pos = line.find(' ');
		cout << "Case #" << i << ": " << stoi(line.substr(0, pos)) + stoi(line.substr(pos + 1)) << endl;
	}
}