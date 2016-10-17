import sys

class GraphNode:
    def __init__(self, key, distance=sys.maxint, predecessor=None):
        self.key = key
        self.distance = distance
        self.predecessor = predecessor

    def __hash__(self):
        return hash(self.key)

    def __eq__(self, other):
        return self.key == other.key

    def __str__(self):
        return "key: {0}, distance: {1}, predecessor: {2}".format(self.key,self.distance,self.predecessor)

    def copy(self):
        return GraphNode(self.key,self.distance,self.predecessor)

class Graph:
    def __init__(self,edges):
        self.vertices = {}
        self.edges = {}
        for u,v,w in edges:
            if not self.vertices.has_key(u):
                self.vertices[u]=GraphNode(u)
            if not self.vertices.has_key(v):
                self.vertices[v]=GraphNode(v)
            self.edges[(u,v)] = float(w)        

    def get_vertices(self):
        for key,node in self.vertices.iteritems():
            yield node

    def get_edges(self):
        for (u,v),w in self.edges.iteritems():
            yield self.vertices[u],self.vertices[v],w

    def copy(self):
        edges = []
        for uNode,vNode,w in self.get_edges():
            edges.append((uNode.key,vNode.key,w))
        return Graph(edges)

    def get_node(self,key):
        return self.vertices[key]

    def vertices_count(self):
        return len(self.vertices)

    def edges_count(self):
        return len(self.edges)
                
def initialize_single_source(graph,s):
    for v in graph.get_vertices():
        v.distance = sys.maxint
        v.predecessor = None
    graph.get_node(s).distance = 0
    
def relax(graph,copyGraph,u,v,w):
    if copyGraph.get_node(v.key).distance > u.distance + w:
        copyGraph.get_node(v.key).distance = u.distance + w
        copyGraph.get_node(v.key).predecessor = copyGraph.get_node(u.key)

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

E = int(raw_input())
edges = []
for i in range(E):
    u,v,w = map(str,raw_input().strip().split(' '))
    edges.append((u,v,float(w)))

sKey = raw_input()

graph = Graph(edges)
copyGraph = Graph(edges)

res = bellman_ford(graph, copyGraph, sKey)
for v in graph.get_vertices():
    print v.key, v.distance, v.predecessor.key if v.predecessor is not None else 'Nil'
print res


        
        
