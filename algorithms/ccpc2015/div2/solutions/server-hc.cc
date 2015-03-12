#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <map>
#include <cassert>

using namespace std;

int read_time()
{
  int h, m;
  char c;
  cin >> h >> c >> m;
  return h*60+m;
}

void solve()
{
  int E, TO;
  cin >> E >> TO;

  set<string> total;
  map<string,int> logins;
  int max_logins = 0;
  
  while (E--) {
    int t = read_time();

    set<string> timeouts;
    for (const auto &p : logins) {
      if (p.second + TO <= t) {
	timeouts.insert(p.first);
      }
    }
    for (const auto &s : timeouts) {
      logins.erase(s);
    }
    
    string type, user_name, action;
    cin >> type;
    if (type == "SERVER") {
      cin >> action;

      // does it matter whether it is start or stop?
      logins.clear();

    } else if (type == "USER") {
      cin >> user_name >> action;
      total.insert(user_name);
      if (action == "LOG_IN") {
	logins[user_name] = t;
      } else {
	logins.erase(user_name);
      }
    } else {
      assert(false);
    }
    max_logins = max(max_logins, (int)logins.size());
  }

  cout << total.size() << ' ' << max_logins << endl;

}

int main()
{
  int T;
  cin >> T;
  while (T--)
    solve();

  return 0;
}
