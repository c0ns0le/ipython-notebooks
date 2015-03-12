#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

// this is not necesarily the best way of doing it but I want to know if it's
// good enough...there are at most 19 digits in a 64-bit signed integer, so
// let's just generate all of them.

vector<ll> list;

void init()
{
  ll p = 1;
  for (int d = 0; d < 19; d++) {
    list.push_back(p);
    for (ll bm = 1; bm < (1 << d); bm++) {
      ll x = p;
      ll q = 1;
      for (int k = 0; k < d; k++) {
	if ((1 << k) & bm) {
	  x += q;
	}
	q *= 10;
      }
      list.push_back(x);
    }
    p *= 10;
  }

  sort(list.begin(), list.end());
}

void solve(int N)
{
  for (int i = 0; i < list.size(); i++) {
    if (list[i] % N == 0) {
      cout << list[i] << endl;
      return;
    }
  }
}

int main()
{
  init();
  
  int T;
  cin >> T;
  while (T--) {
    int N;
    cin >> N;
    solve(N);
  }
  return 0;
}
