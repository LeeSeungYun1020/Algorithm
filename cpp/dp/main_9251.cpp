#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string str1, str2;
	cin >> str1 >> str2;
	const int len1 = str1.length();
	const int len2 = str2.length();
	int** array = new int*[len1 + 1];
	array[0] = new int[len2 + 1]{0,};
	for (int i = 1; i <= len1; ++i) {
		array[i] = new int[len2 + 1];
		array[i][0] = 0;
		for (int j = 1; j <= len2; ++j) {
			if (str1[i - 1] == str2[j - 1]) {
				array[i][j] = array[i - 1][j - 1] + 1;
			} else {
				array[i][j] = max(array[i - 1][j], array[i][j - 1]);
			}
		}
	}
	cout << array[len1][len2];
}
