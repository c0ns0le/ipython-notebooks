from collections import defaultdict

def DFS(graph, point, visited):
    for neigh in graph[point]:
        if neigh not in visited:
            visited.add(neigh)
            DFS(graph, neigh, visited)

def solve(lines):
    graph = defaultdict(list)
    for line in lines:
        graph[line[0]].append(line[1])
        graph[line[1]].append(line[0])
    visited = set()
    start = lines[0][0]
    visited.add(start)
    print lines
    print graph
    DFS(graph, start, visited)
    if len(visited) != len(graph.keys()):
        return False
    odds = sum([1 for item in graph if len(graph[item])%2 != 0])
    if odds != 0 and odds != 2:
        return False
    return True

line_number = int(raw_input())
while line_number != 0:
    lines = []
    for i in range(line_number):
        a, b, c, d = map(int, raw_input().split())
        lines.append([(a,b), (c,d)])
    res = solve(lines)
    if res:
        print "possible"
    else:
        print "impossible"
    line_number = int(raw_input())
