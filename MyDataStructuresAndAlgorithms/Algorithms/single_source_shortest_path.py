import sys
from graph import *
from heap import *

class ShortestPathGraphNode(Node,HeapNode):
    def __init__(self, key, distance=sys.maxint, predecessor=None):
        Node.__init__(self, key)
        self.distance = distance
        self.predecessor = predecessor

    def __str__(self):
        return "key: {0}, distance: {1}, predecessor: {2}".format(self.key,self.distance,self.predecessor)

    def get_heap_key(self):
        return self.distance

    def set_heap_key(self,distance):
        self.distance = distance
            
def initialize_single_source(graph,s):
    for v in graph.get_vertices():
        v.distance = sys.maxint
        v.predecessor = None
    graph.get_node(s).distance = 0
    
def relax(graph,copyGraph,u,v,w):
    if copyGraph.get_node(v.key).distance > u.distance + w:
        copyGraph.get_node(v.key).distance = u.distance + w
        copyGraph.get_node(v.key).predecessor = copyGraph.get_node(u.key)

def relax(u, v, w):
    if v.distance > u.distance + w:
        v.distance = u.distance + w
        v.predecessor = u

def bellman_ford(graph, copyGraph, s):
    initialize_single_source(graph, s)
    initialize_single_source(copyGraph, s)
    for i in range(graph.vertices_count()-1):
        for u,v,w in graph.get_edges():
            relax(graph, copyGraph, u, v, w)
        
        temp = graph
        graph = copyGraph
        copyGraph = temp
    
    for u,v,w in graph.get_edges():
        if v.distance > u.distance + w:
            return False

    return True

def dijkstra(graph, s):
    initialize_single_source(graph,s)
    q = MinPriorityQueue.from_heapNodes(graph.get_vertices())
    S = set()
    while q.heapSize > 0:
        u = q.extract_min()
        S.add(u)
        for v in graph.get_adjs(u):
            #relaxation
            if v.distance > u.distance + graph.get_weight(u,v):
                q.decrease_key(v, u.distance + graph.get_weight(u,v))
                v.predecessor = u

def test_bellman_ford():
    vertices = raw_input().strip().split(' ')
    E = int(raw_input())
    edges = []
    weights = []
    for i in range(E):
        u,v,w = map(str,raw_input().strip().split(' '))
        edges.append((u,v))
        weights.append(float(w))

    sKey = raw_input()
    graph = DirectedWeightedGraph(vertices,edges,weights,ShortestPathGraphNode)
    copyGraph = DirectedWeightedGraph(vertices,edges,weights,ShortestPathGraphNode)

    res = bellman_ford(graph, copyGraph, sKey)
    for v in graph.get_vertices():
        print v.key, v.distance, v.predecessor.key if v.predecessor is not None else 'Nil'
    print res

def test_dijkstra():
    vertices = raw_input().strip().split(' ')
    E = int(raw_input())
    edges = []
    weights = []
    for i in range(E):
        u,v,w = map(str,raw_input().strip().split(' '))
        edges.append((u,v))
        weights.append(float(w))

    sKey = raw_input()
    graph = DirectedWeightedGraph(vertices,edges,weights,ShortestPathGraphNode)
    dijkstra(graph, sKey)
    for v in graph.get_vertices():
        print v.key, v.distance, v.predecessor.key if v.predecessor is not None else 'Nil'
        
        
