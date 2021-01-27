#include <iostream>

using namespace std;

int main() {
    int count;
    cin >> count;
    for (int i = 0; i < count; ++i) {
	    int h, w, n;
        cin >> h >> w >> n;
        int floor = n % h;
        int room = n / h + 1;
        if (floor == 0) {
            floor = h;
            room -= 1;
        }
        cout << floor;
        if (room < 10) 
            cout << 0;
        cout << room << endl;
    }
}