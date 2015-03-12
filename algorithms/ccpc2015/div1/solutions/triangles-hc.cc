#include <iostream>

using namespace std;

typedef long long ll;

int main()
{
  int T;
  cin >> T;
  while (T--) {
    ll A, B;
    cin >> A >> B;
    A /= B;
    cout << A*A << endl;
  }
  return 0;
}
