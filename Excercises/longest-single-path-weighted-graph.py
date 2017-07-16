

def solve(graph,s,t,n):
    table = [-10**9 for x in range(n)]
    table[s] = 0
    q = [s]
    while len(q):
        node = q.pop(0)
        if node not in graph:
            continue
        for v,w in graph[node]:
            if table[v] < table[node] + w:
                table[v] = table[node] + w
                q.append(v)

    return table[t]


#vertices and edges
n,e = tuple(map(int,input().strip().split(' ')))
graph = {}
for i in range(e):
    u,v,w = tuple(map(int, input().strip().split(' ')))
    graph.setdefault(u,[]).append((v,w))

s,t = tuple(map(int,input().strip().split(' ')))
print(graph, s, t)
print(solve(graph, s, t, n))
