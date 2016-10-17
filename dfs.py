from graph import *

class DFSGraphNode(GraphNode):
    def __init__(self,key):
        GraphNode.__init__(self, key)
        self.colour = ''
        self.parent = None
        self.d = 0
        self.f = 0

    def __str__(self):
        return "{0} {1}:{2}".format(self.key,self.d,self.f)

def dfs(graph):
    for u in graph.get_vertices():
        u.colour = 'WHITE'
        u.parent = None
    global time
    time = 0
    for u in graph.get_vertices():
        if u.colour == 'WHITE':
            dfs_visit(graph,u)

def dfs_visit(graph, u):
    global time
    time += 1
    u.d = time
    u.colour = 'GRAY'
    for v in graph.get_adjs(u):
        if v.colour == 'WHITE':
            v.parent = u
            dfs_visit(graph,v)
    u.colour = 'BLACK'
    time += 1
    u.f = time

def test_dfs():
    n = int(raw_input('Enter the number of edges '))
    edges = []
    for i in range(n):
        (u,v) = raw_input().strip().split(' ')
        edges.append((u,v))

    graph = DirectedGraph(edges,DFSGraphNode)
    dfs(graph)
    print ''
    for v in graph.get_vertices():
        print v
