#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

typedef pair<int,int> pii;

// note that the sum can be at most 3*2^24
void solve()
{
  int N;
  cin >> N;
  int A[10000];

  int maxsum = 0;
  for (int i = 0; i < N; i++) {
    cin >> A[i];
    maxsum = max(A[i], maxsum);
  }

  int curr_sum = 3;

  // compute intervals that can form 3*2^0 (separately)
  set<pii> curr;
  for (int i = 0; i < N; i++) {
    if (A[i] == 3)
      curr.insert(pii(i,i));
    if (A[i] == 1) {
      if (i > 0 && A[i-1] == 2)
	curr.insert(pii(i-1,i));
      if (i < N-1 && A[i+1] == 2)
	curr.insert(pii(i,i+1));
    }
  }
  if (curr.size() > 0)
    maxsum = max(maxsum, curr_sum);

  for (int i = 1; i <= 24; i++) {
    // loop through all the intervals that can form sums of 3*2^i
    set<pii> next;

    curr_sum *= 2;

    // first check if there are any entries == curr_sum
    for (int i = 0; i < N; i++) {
      if (A[i] == curr_sum) 
	next.insert(pii(i,i));
    }

    // now try to merge the old ones
    for (const auto&p  : curr) {
      pii s(p.second+1, 0);
      for (auto it = curr.lower_bound(s);
	   it != curr.end() && it->first == s.first; ++it) {
	next.insert(pii(p.first, it->second));
      }
    }

    if (next.size() > 0)
      maxsum = max(maxsum, curr_sum);

    curr.swap(next);
  }

  cout << maxsum << endl;

}

int main()
{
  int T;
  cin >> T;
  while (T--)
    solve();

  return 0;
}
