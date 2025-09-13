#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int times;
  cin >> times;
  for (int i = 0; i < times; ++i) {
    long long n;
    cin >> n;
    long long ans = (n << 1) - (n & 1LL);
    cout << ans << '\n';
  }

  return 0;
}