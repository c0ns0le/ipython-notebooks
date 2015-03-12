from collections import deque, defaultdict

def solve(N, d):

    prev = defaultdict(lambda: -2)
    digit = defaultdict(int)

    q = deque()
    for i in xrange(len(d)):
        if d[i] !=0 and prev[d[i]%N] == -2:
            prev[d[i]%N] = -1
            digit[d[i]%N] = d[i]
            q.append(d[i]%N)

    while q and prev[0] == -2:
        curr = q.popleft()
        for i in xrange(len(d)):
            next_number = ((curr*16)%N + d[i])%N
            if prev[next_number] == -2:
                prev[next_number] = curr
                digit[next_number] = d[i]
                q.append(next_number)
    if prev[0] == -2:
        print "no solution"
    else:
        s = num_to_char[digit[0]]
        t = prev[0]
        while t != -1:
            s = num_to_char[digit[t]] + s
            t = prev[t]
        print s

tc = int(raw_input())
num_to_char = {int(item, 16): item for item in "0123456789abcdef"}
char_to_num = {v: k for k, v in num_to_char.items()}
for i in range(tc):
    N = map(int, raw_input().split())[0]
    hex_list = raw_input().split()
    solve(N, [char_to_num[item] for item in hex_list])
