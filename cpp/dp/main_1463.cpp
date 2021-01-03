#include <iostream>
#include <vector>

using namespace std;

int main() {
	int num;
	cin >> num;

	int* arr = new int[num + 1];
	arr[0] = 0;
	arr[1] = 0;
	for (int i = 2; i <= num; ++i) {
		if (i % 6 == 0) {
			arr[i] = (min(min(arr[i / 3], arr[i / 2]), arr[i - 1]) + 1);
		}
		else if (i % 3 == 0) {
			arr[i] = (min(arr[i / 3], arr[i - 1]) + 1);
		}
		else if (i % 2 == 0) {
			arr[i] = (min(arr[i / 2], arr[i - 1]) + 1);
		}else {
			arr[i] = (arr[i - 1] + 1);
		}
	}
	
	cout << arr[num] << endl;
}
