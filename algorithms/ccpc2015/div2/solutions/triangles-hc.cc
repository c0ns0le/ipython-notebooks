#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
  int T;
  cin >> T;
  while (T--) {
    int A, B;
    cin >> A >> B;
    A /= B;
    cout << A*A << endl;   // I suppose I could just sum up the odd numbers...
  }
  return 0;
}
