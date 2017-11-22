def tree_diameter(g):
    root = g.keys()[0]
    q = [root]
    distances = {}
    distances[root] = 0
    furthestNode = root
    
    while len(q) > 0:
        current = q.pop(0)
        if distances[furthestNode] < distances[current]:
            furthestNode = current
        
        for node in g[current]:
            if distances.has_key(node):
                continue
            distances[node] = distances[current]+1
            q.append(node)
    
    distances = { furthestNode : 0}
    q = [furthestNode]
    diameter = 0
    while len(q) > 0:
        current = q.pop(0)
        if diameter < distances[current]:
            diameter = distances[current]
        for node in g[current]:
            if distances.has_key(node):
                continue
            distances[node] = distances[current] + 1
            q.append(node)
    return diameter

g = {}
n = int(raw_input())
for i in range(n):
    u,v = map(int,raw_input().split(' '))
    if g.has_key(u):
        g[u].append(v)
    else:
        g[u]=[v]
    if g.has_key(v):
        g[v].append(u)
    else:
        g[v]=[u]

print tree_diameter(g)
