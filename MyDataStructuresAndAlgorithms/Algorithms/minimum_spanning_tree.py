import sys
from heapq import *

class TreeNode:
    def __init__(self,value,parent,adjValuesWeights):
        self.id = value
        self.p = parent
        self.key = sys.maxint
        self.adj = adjValuesWeights
        self.removed = False

    def w(self,v):
        if v is None:
            return sys.maxint
        adj = [x[0] for x in self.adj]
        ws = [x[1] for x in self.adj]
        if v.id not in adj:
            return sys.maxint
        return ws[adj.index(v.id)]

    def __hash__(self):
        return hash(self.id)

    def __eq__(self,other):
        return self.id == other.id

    def __ne__(self, other):
        return not self.id == other.id

    def __str__(self):
        return '{0} {1}'.format(self.value,self.adj)

class Heap:
    def __init__(self, nodes):
        self.q = map(lambda x: (x.key,x), nodes)
        heapify(self.q)
        self.d = {}
        for n in nodes:
            self.d[n.id] = n
        self.heapCount = len(nodes)

    def contains(self,nodeId):
        return self.d.has_key(nodeId)

    def pop(self):
        key,node = heappop(self.q)
        while node.removed:
            key,node = heappop(self.q)
        self.d.pop(node.id)
        self.heapCount -= 1
        return (key,node.id)

    def heap_size(self):
        return self.heapCount

    def heap_update_key(self,node,newKey):
        d = self.d
        d[node.id].removed = True
        d.pop(node.id)
        newNode = TreeNode(node.id,node.p,node.adj)
        newNode.key = newKey
        d[newNode.id]=newNode
        heappush(self.q,(newNode.key,newNode))
    


def mst_prim(g,r):
    #initialize and build heap
    A = set()
    r.key = 0
    heap = Heap(g.values())
    
    #print q
    while heap.heap_size() > 0:
        u = heap.pop()#(key,id)
        uNode = graph[u[1]]
        A.add((uNode,uNode.p))
        for adj in uNode.adj:
            adjNode = g[adj[0]]
            if heap.contains(adjNode.id) and uNode.w(adjNode) < adjNode.key:
                adjNode.p = uNode
                adjNode.key = uNode.w(adjNode)
                heap.heap_update_key(adjNode,uNode.w(adjNode))
    return A

graph = {}
e = int(raw_input())
for i in range(e):
    (u,v,w) = map(str,raw_input().split(' '))
    w = int(w)
    if not graph.has_key(u):
        graph[u] = TreeNode(u,None,[])
    if not graph.has_key(v):
        graph[v] = TreeNode(v,None,[])
    
    uNode = graph[u]
    uNode.adj.append((v,w))
    vNode = graph[v]
    vNode.adj.append((u,w))

##for k,v in graph.iteritems():
##    print v

A = mst_prim(graph,graph['a'])
for u,v in A:
    print u.id, v.id if v is not None else 'Nil'
