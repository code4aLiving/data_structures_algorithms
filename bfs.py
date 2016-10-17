from graph import *
import sys
from collections import deque

class BFSGraphNode(GraphNode):
    def __init__(self,key):
        GraphNode.__init__(self,key)
        self.distance = 0
        self.colour = 'WHITE'
        self.parent = None

    def __str__(self):
        return "{0} {1} {2}".format(self.key,self.distance,self.colour)

def bfs(graph,s):
    for u in graph.get_adjs(s):
        u.colour = 'WHITE'
        u.distance = sys.maxint
        u.parent = None
    s.colour = 'GRAY'
    s.distance = 0
    s.parent = None
    q = deque()
    q.append(s)
    while len(q) > 0:
        u = q.popleft()
        for v in graph.get_adjs(u):
            if v.colour == 'WHITE':
                v.colour = 'GRAY'
                v.distance = u.distance + 1
                v.parent = u
                q.append(v)
        u.colour = 'BLACK'

n = int(raw_input('Enter the number of edges '))
edges = []
for i in range(n):
    (u,v) = raw_input().strip().split(' ')
    edges.append((u,v))

graph = UndirectedGraph(edges, BFSGraphNode)
bfs(graph, graph.get_node('s'))
print ''
for v in graph.get_vertices():
    print v



