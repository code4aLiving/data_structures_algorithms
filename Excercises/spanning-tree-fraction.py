
class Fraction(object):
    def __init__(self,p,q):
        self.p = p
        self.q = q

    def get_value(self):
        if self.q == 0:
            return -1
        return self.p/self.q

    def __str__(self):
        return "{}/{}".format(self.p,self.q)

    def simplify(self):
        p = self.p
        q = self.q
        d = min(p,q)        
        while d > 1:
            p //= d
            q //= d
            d = min(d-1,min(p,q))
        return Fraction(p,q)

def get_max(tree_fraction, graph, tree):
    res = None
    max_f = Fraction(tree_fraction.p, tree_fraction.q)
    addedNode = False
    for node in tree:
        #print('tree node {}'.format(node))
        for u,f in graph[node]:
            #print('Neigbor {}'.format(u))
            if u in tree:
                continue
            new_f = Fraction(tree_fraction.p + f.p,tree_fraction.q + f.q)
            #print(new_f,max_f,f)
            if not addedNode or new_f.get_value() > max_f.get_value():
                max_f = new_f
                res = (u,new_f,f)
                addedNode=True
    return res
            

def spanningTreeFraction(n,graph,root):
    tree = set([root])
    res = Fraction(0,0)
    
    while len(tree) < n:
        #print('Tree ',tree)
        node,new_res,f = get_max(res,graph,tree)
        #print(res,new_res,f)
        res = new_res
        tree.add(node)

    return res

graph = {}
n,m = tuple(map(int,input().split(' ')))
for i in range(m):
    u,v,p,q = list(map(int,input().split(' ')))
    f = Fraction(p,q)
    graph.setdefault(u,[]).append((v,f))
    graph.setdefault(v,[]).append((u,f))

print(spanningTreeFraction(n,graph,0).simplify())
