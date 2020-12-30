#include <iostream>
#include <string>

using namespace std;

int main() {
	string line;
	getline(cin, line);
	
	int len = stoi(line);
	getline(cin, line);
	
	int sum = 0;
	for (int i = 0; i < len; ++i) {
		sum += stoi(line.substr(i, 1));
	}
	cout << sum;
}
