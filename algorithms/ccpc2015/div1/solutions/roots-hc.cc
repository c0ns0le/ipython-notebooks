#include <iostream>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

typedef long long ll;
typedef long double ld;

// return x^2 if it can fit in long long, or LLONG_MAX otherwise
ll square(ll x)
{
  const ll INF = LLONG_MAX;

  if (x > 0 && x > INF / x) 
    return INF;

  return x*x;
}

bool solve()
{
  ll  a, b, c, s, t;
  cin >> a >> b >> c >> s >> t;

  // make a positive
  if (a < 0) {
    a = -a; b = -b; c = -c;
  }

  ll disc = b*b-4*a*c;
  if (disc < 0) return false;       // no roots

  ll lower = 2*a*s, upper = 2*a*t;
  if (disc == 0) {
    // one root at x = -b/2a
    return 2*a*s <= -b && -b <= 2*a*t;
  }

  // otherwise
  //
  // lower+b <= +/- sqrt(disc) <= upper+b
  lower += b;
  upper += b;

  // three cases based on the sign of lower and upper (== 0 can go into either
  // case)
  if (lower >= 0) {
    // only have to consider + sq root
    return square(lower) <= disc && disc <= square(upper);
  } else if (upper <= 0) {
    // only have to consider - sq root
    return square(-upper) <= disc && disc <= square(-lower);
  } else {
    // need to know if [L,0] has - sq root and [0,U] has + sq root
    return disc <= square(upper) || disc <= square(-lower);
  }
}

int main()
{
  int N;
  cin >> N;
  while (N--)
    cout << (solve() ? "Yes" : "No") << endl;

  return 0;
}
