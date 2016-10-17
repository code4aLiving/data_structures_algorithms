
class Node:
    def __init__(self, key):
        self.key = key

    def __hash__(self):
        return hash(self.key)

    def __eq__(self, other):
        return self.key == other.key

    def __str__(self):
        return str(self.key)

    def get_id(self):
        return self.key    

class Graph(object):
    def __init__(self, vertices, edges, GraphNodeClass):
        self.vertices = {}
        self.adjList = {}
        for v in vertices:
            self.vertices[v] = GraphNodeClass(v)
            self.adjList[self.vertices[v]] = []

    def get_vertices(self):
        vertices = [node for key, node in self.vertices.iteritems()]
        return vertices

    def get_adjs(self, node):
        return self.adjList[node]

    def get_node(self, key):
        return self.vertices[key]

    def vertices_count(self):
        return len(self.vertices)

class UndirectedGraph(Graph):
    def __init__(self, vertices, edges, GraphNodeClass):
        Graph.__init__(self,vertices, edges, GraphNodeClass)
        self.__init_adjList__(edges)
        
    def __init_adjList__(self,edges):
        for u,v in edges:
            self.adjList[self.vertices[u]].append(self.vertices[v])
            self.adjList[self.vertices[v]].append(self.vertices[u])

class DirectedGraph(Graph):
    def __init__(self, vertices, edges, GraphNodeClass):
        Graph.__init__(self, vertices, edges, GraphNodeClass)
        self.__init_adjList__(edges)

    def __init_adjList__(self, edges):
        for u,v in edges:
            self.adjList[self.vertices[u]].append(self.vertices[v])
        
class WeightedGraph(UndirectedGraph):
    def __init__(self, vertices, edges, weights, GraphNodeClass):
        UndirectedGraph.__init__(self, vertices, edges, GraphNodeClass)
        self.edges = {}
        self.__init_edges__(edges, weights)

    def __init_edges__(self, edges, weights):
        for i in range(len(weights)) :
            (u,v) = edges[i]
            self.edges[(self.vertices[u],self.vertices[v])]=weights[i]
            self.edges[(self.vertices[v],self.vertices[u])]=weights[i]

    def get_edges(self):
        for (u,v),w in self.edges.iteritems():
            yield u,v,w

    def get_weight(self,u,v):
        return self.edges[(u,v)]

    def edges_count(self):
        return len(self.edges)
            

class DirectedWeightedGraph(DirectedGraph, WeightedGraph):
    def __init__(self,vertices, edges, weights, GraphNodeClass):
        DirectedGraph.__init__(self, vertices, edges, GraphNodeClass)
        self.edges = {}
        self.__init_edges__(edges,weights)
    
    def __init_edges__(self, edges, weights):
        for i in range(len(weights)):
            (u,v) = edges[i]
            self.edges[(self.vertices[u],self.vertices[v])]=weights[i]
