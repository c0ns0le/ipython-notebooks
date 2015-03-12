#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>

using namespace std;

int N[10];
int x[10][1000];

void solve(string input)
{
  for (auto &c : input) {
    if (c == '+') c = ' ';
  }

  istringstream iss(input);
  fill(N, N+10, 0);

  int temp;
  while (iss >> temp) {
    int rem = temp % 10;
    x[rem][N[rem]++] = temp;
  }

  bool printed = false;
  for (int i = 1; i <= 4; i++) {
    while (N[i] > 0 && N[10-i] > 0) {
      if (printed) cout << '+';
      cout << x[i][--N[i]] << '+' << x[10-i][--N[10-i]];
      printed = true;
    }
  }
  while (N[5] >= 2) {
    if (printed) cout << '+';
    cout << x[5][N[5]-1] << '+' << x[5][N[5]-2];
    N[5] -= 2;
    printed = true;
  }
  while (N[0] >= 2) {
    if (printed) cout << '+';
    cout << x[0][N[0]-1] << '+' << x[0][N[0]-2];
    N[0] -= 2;
    printed = true;
  }

  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < N[i]; j++) {
      if (printed) cout << '+';
      cout << x[i][j];
      printed = true;
    }
  }
  cout << endl;
}

int main()
{
  string input;
  while (cin >> input && input != "0") {
    solve(input);
  }
  return 0;
}
