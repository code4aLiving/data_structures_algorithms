

import sys

def dfs(graph):
    visited = set()
    res = 0
    for u in graph.keys():
        if u not in visited:
            tree = set([u])
            edges = set()
            temp,l = dfs_visit(graph,visited,u,tree,edges)
            temp2 = 0
            for x in tree:
                for y in graph[x]:
                    if (x,y) not in edges and (y,x) not in edges:
                        temp2+=l[-1]
                        edges.add((x,y))
                        
            res+=temp+temp2
    return res
        
def dfs_visit(graph,visited,u,tree,edges):
    visited.add(u)
    res = 0
    l = []
    for v in graph[u]:
        if v in visited:
            continue
        tree.add(v)
        edges.add((u,v))
        res += (len(tree)-1)*len(tree)
        l.append((len(tree)-1)*len(tree))
        #print(res,tree,edges,l)
        t,lt = dfs_visit(graph,visited,v,tree,edges)
        res += t
        l.extend(lt)
    return res,l
    

t = int(input().strip())
for a0 in range(t):
    n,m = input().strip().split(' ')
    n,m = [int(n),int(m)]
    graph = {}
    for a1 in range(m):
        x,y = input().strip().split(' ')
        x,y = [int(x),int(y)]
        #print(x,y)
        graph.setdefault(x,[y]).append(y)
        graph.setdefault(y,[x]).append(x)
    print(dfs(graph))
        # your code goes here
