#include <iostream>
#include <vector>

using namespace std;

void readGroupRelation(int numberOfRelation);

int find(int target);

void merge(int a, int b);

void printScenario(int scenarioIndex);

vector<int> group;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int scenario;
    cin >> scenario;
    for (auto i = 0; i < scenario; ++i) {
        int numberOfPeople, numberOfRelation;
        cin >> numberOfPeople >> numberOfRelation;
        group.resize(numberOfPeople);
        for (auto j = 0; j < numberOfPeople; ++j) {
            group[j] = j;
        }
        readGroupRelation(numberOfRelation);
        printScenario(i);
    }
    return 0;
}

void readGroupRelation(const int numberOfRelation) {
    for (auto i = 0; i < numberOfRelation; ++i) {
        int a, b;
        cin >> a >> b;
        merge(a, b);
    }
}

int find(const int target) {
    if (group[target] == target)
        return target;
    return group[target] = find(group[target]);
}

void merge(const int a, const int b) {
    int aRoot = find(a);
    int bRoot = find(b);
    if (aRoot == bRoot) return;
    group[aRoot] = bRoot;
}

void printScenario(const int scenarioIndex) {
    cout << "Scenario " << scenarioIndex + 1 << ":\n";
    int numberOfCheck;
    cin >> numberOfCheck;
    for (int i = 0; i < numberOfCheck; ++i) {
        int u, v;
        cin >> u >> v;
        cout << (find(u) == find(v)) << "\n";
    }
    cout << "\n";
}