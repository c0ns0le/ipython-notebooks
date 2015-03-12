#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

typedef pair<string,string> pss;

pss read_name()
{
  pss p;
  cin >> p.second >> p.first;
  return p;
}

int main()
{
  int N;
  cin >> N;

  vector<pss> names(N);
  for (int i = 0; i < N; i++) {
    pss p = read_name();
    names[i] = p;
  }
  sort(names.begin(), names.end());

  int T;
  cin >> T;
  for (int i = 0; i < T; i++) {
    pss p = read_name();
    int t = lower_bound(names.begin(), names.end(), p) - names.begin();
    int b = t - t % 3;
    for (int j = b; j < b+3; j++) {
      if (j == t) continue;
      cout << names[j].second << ' ' << names[j].first << endl;
    }
  }

  return 0;
}
