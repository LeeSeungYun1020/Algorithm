#include <iostream>

using namespace std;

int main() {
    int input;
    cin >> input;
    if (input % 5 == 0) {
        cout << input / 5 << endl;
    	return 0;
    }

    for (int i = input / 5; i >= 0; --i) {
	    const int left = input - i * 5;
    	if (left % 3 == 0) {
            cout << i + left / 3 << endl;
        	return 0;
        }
    }
    cout << -1 << endl;
	return 0;
}