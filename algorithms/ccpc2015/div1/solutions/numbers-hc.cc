#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

void solve()
{
  int N, D;
  int d[16];

  cin >> N >> D;
  for (int i = 0; i < D; i++) {
    char c;
    cin >> c;
    if (isdigit(c)) {
      d[i] = c - '0';
    } else {
      d[i] = c - 'a' + 10;
    }
  }

  int prev[200000];
  int digit[200000];
  fill(prev, prev+N, -2);

  queue<int> q;
  for (int i = 0; i < D; i++) {
    if (d[i] == 0) continue;    // don't count 0
    if (prev[d[i] % N] == -2) {
      prev[d[i] % N] = -1;
      digit[d[i] % N] = d[i];
      q.push(d[i] % N);
    }
  }

  while (!q.empty() && prev[0] == -2) {
    int curr = q.front();
    q.pop();
    for (int i = 0; i < D; i++) {
      int next = ((curr*16)%N + d[i]) % N;
      if (prev[next] == -2) {
	prev[next] = curr;
	digit[next] = d[i];
	q.push(next);
      }
    }
  }

  if (prev[0] == -2) {
    cout << "no solution" << endl;
  } else {
    int t = 0;
    string out;
    do {
      if (digit[t] < 10) {
	out += char(digit[t]+'0');
      } else {
	out += char(digit[t] - 10 + 'a');
      }
      t = prev[t];
    } while (t != -1);
    reverse(out.begin(), out.end());
    cout << out << endl;
  }
}

int main()
{
  int T;
  cin >> T;
  while (T--) 
    solve();

  return 0;
}
