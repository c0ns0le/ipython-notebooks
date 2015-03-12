import bisect

def threes(A):
    max_sum = max(A)
    curr_sum = 3

    curr = []
    for i in range(len(A)):
        if A[i] == 3:
            #position = bisect.bisect(curr, (i, i))
            current.append((i, i))
        if A[i] == 1:
            if i > 0 and A[i-1] == 2:
                curr.append((i-1, i))
            if i < len(A) - 1 and A[i+1] == 2:
                curr.append((i, i+1))
    if curr:
        max_sum = max(max_sum, curr_sum)

    for i in range(1, 25):
        next_list = []
        curr_sum *= 2
        for i in range(len(A)):
            if A[i] == curr_sum:
                bisect.insort(next_list, (i, i))
        for p in curr:
            s = (p[1]+1, 0)
            position = bisect.bisect(curr, s)
            for j in range(position, len(curr)):
                if curr[j][0] == s[0]:
                    bisect.insort(next_list, (p[0], curr[j][1]))
                else:
                    break
        if next_list:
            max_sum = max(max_sum, curr_sum)

        curr = next_list

    print(max_sum)

tc = int(raw_input())
for i in range(tc):
    raw_input()
    A = map(int, raw_input().split())
    threes(A)
