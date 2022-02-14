#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[1000000];
    int original[1000000];
    map<int, int> n_map;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        original[i] = arr[i];
    }
    sort(arr, arr + n);
    int idx = 0;
    int prev = arr[0];
    n_map.insert({ prev, idx++ });
    for (int i = 1; i < n; i++) {
        if (prev != arr[i]) {
            n_map.insert({ arr[i], idx++ });
            prev = arr[i];
        }
    }

    for (int i = 0; i < n - 1; i++) {
        cout << n_map[original[i]] << " ";
    }
    cout << n_map[original[n - 1]];

    return 0;
}