#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int count;
	cin >> count;

	vector<string> words;
	string word;
	for (int i = 0; i < count; ++i) {
		cin >> word;
		words.push_back(word);
	}

	sort(words.begin(), words.end(), [](const string & s1, const string & s2) {
		if (s1.length() == s2.length()) {
			return s1 < s2;
		}
		return s1.length() < s2.length();
	});
	words.erase(unique(words.begin(), words.end()), words.end());
	for (auto && w : words) {
		cout << w << '\n';
	}
}