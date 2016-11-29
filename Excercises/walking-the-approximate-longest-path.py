
class Node:
    def __init__(self,value):
        self.value = value
        self.d = 0
        self.f = 0
        self.p = None
        self.degree = 0
    
    def __hash__(self):
        return hash(self.value)
    def __eq__(self,other):
        return self.value == other.value

##time = 0
##def dfs(node,g):
##    node.d = time
##    global time += 1
##    #adjs = [g[node]
##    #
##    for adj in g[node]:
##        if adj.d == 0:
##            adj.p = node
##            dfs(adj,g)
##    node.f = time
##    global time += 1
##
def set_degree(g):
    for k,v in g.iteritems():
        k.degree = len(v)

def get_path(g,u):
    path = []
    visited = set()
    while u is not None:
        path.append(u)
        visited.add(u)
        v = get_adj(g,u,visited)
        if v is None:
            break
        v.p = u
        u = v        
    return path
    

def get_adj(g,u,visited):
    adjs = sorted(g[u],key = lambda x : x.degree)
    for v in adjs:
        if v in visited:
            continue
        
        return v
    return None

n,m = map(int,raw_input().split(' '))
g = {}
for i in range(m):
    x,y = map(int,raw_input().split(' '))
    xn = Node(x)
    yn = Node(y)
    if g.has_key(xn):
        g[xn].append(yn)
    else:
        g[xn]=[yn]

    if g.has_key(yn):
        g[yn].append(xn)
    else:
        g[yn]=[xn]

set_degree(g)
path = get_path(g,g.keys()[0])
print len(path)
print ' '.join(map(str,[n.value for n in path]))

    
