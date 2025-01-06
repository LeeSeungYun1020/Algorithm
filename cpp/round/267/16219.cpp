#include <vector>
#include <bits/stdc++.h>

using namespace std;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);

  int size;
  cin >> size;

  vector<int> game(size);
  int check = 0;
  for (int i = 0; i < size; i++) {
    cin >> game[i];
    if (game[i] != i) { check++; }
  }

  int round;
  cin >> round;
  for (int idx = 0; idx < round; idx++) {
    int i, j;
    cin >> i >> j;
    if (i != j) {
      if (i != game[i]) check--;
      if (j != game[j]) check--;
      swap(game[i], game[j]);
      if (i != game[i]) check++;
      if (j != game[j]) check++;
    }
    if (game.size() == 2 && check == 2) cout << "1 ";
    else if (check == 0) cout << "0 ";
    else cout << "-1 ";
  }
  return 0;
}
