#include <iostream>
#include <algorithm>

using namespace std;

void solve()
{
  int N, dice[6];
  cin >> N;
  for (int i = 0; i < 6; i++) {
    cin >> dice[i];
  }

  int score = 0;
  int curr_sq = 0;
  int d_i = 0;

  while (curr_sq != N) {
    if (curr_sq + dice[d_i] <= N) {
      curr_sq += dice[d_i];
      score += curr_sq;
    }
    d_i = (d_i + 1) % 6;
  }
  cout << score << endl;
}

int main()
{
  int T;
  cin >> T;
  while (T--)
    solve();
  return 0;
}
