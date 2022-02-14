#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

class Member {
	int age;
	string name;
public:
	Member(int age, string name) :age(age), name(std::move(name)) {}
	bool operator<(const Member& m) const {
		return age < m.age;
	}
	friend ostream& operator<<(ostream& os, const Member& m) {
		os << m.age << ' ' << m.name;
		return os;
	}
};

int main() {
	int count;
	cin >> count;

	vector<Member> members;
	int age;
	string name;
	for (int i = 0; i < count; ++i) {
		cin >> age >> name;
		members.emplace_back(Member(age, name));
	}

	stable_sort(members.begin(), members.end());
	for (auto && member : members) {
		cout << member << '\n';
	}
}