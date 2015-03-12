
def threes(all_poss, num):
    max_val = max(num)
    b = [[0]*len(num) for _ in range(len(all_poss))]
    for i in range(len(num)):
        b[2][i] = -1

    for i in range(len(num)):
        if num[i] == 1:
            if i < len(num) - 1 and num[i+1] == 2:
                b[2][i] = i+1
                max_val = max(3, max_val)
        elif num[i] == 2:
            if i < len(num)-1 and num[i+1] == 1:
                b[2][i] = i+1
                max_val = max(3, max_val)
        elif num[i] == 3:
            b[2][i] = i

    for cur in range(3, len(all_poss)):
        for i in range(len(num)):
            if b[cur-1][i] >= 0 and b[cur-1][i]+1<len(num) and b[cur-1][b[cur-1][i]+1] >= 0:
                b[cur][i] = b[cur-1][b[cur-1][i]+1]
                max_val = max(max_val, all_poss[cur])
            elif  num[i] == all_poss[cur]:
                b[cur][i] = i
            else:
                b[cur][i] = -1

    print max_val


all_poss = [0]*27
all_poss[1] = 2
all_poss[2] = 3
for i in range(3, 27):
    all_poss[i] = 2*all_poss[i-1]


tc = int(raw_input())
for i in range(tc):
    raw_input()
    A = map(int, raw_input().split())
    threes(all_poss, A)
