#include <iostream>
#include <string>

using namespace std;

int main() {
	string line;
	getline(cin, line);
	for (int i = 0; i < line.length(); ++i) {
		cout << line[i];
		if ((i+1) % 10 == 0) {
			cout << endl;
		}
	}
}
