
class GraphNode:
    def __init__(self, key):
        self.colour = ''
        self.parent = None
        self.key = key

    def __hash__(self):
        return hash(self.key)

    def __eq__(self, key):
        return self.key == other.key

class Graph:
    def __init__(self,edges):
        self.vertices = {}
        self.adjList = {}
        for u,v in edges:
            if not self.vertices.has_key(u):
                self.vertices[u] = GraphNode(u)
                self.adjList[self.vertices[u]] = []
            if not self.vertices.has_key(v):
                self.vertices[v] = GraphNode(v)
                self.adjList[self.vertices[v]] = []

class UndirectedGraph(Graph):
    def __init__(self, edges):
        Graph.__init__(self,edges)
        self.__init_edges__()
        
    def __init_adjList__(self,edges):
        for u,v in edges:
            self.adjList[self.vertices[u]].append(self.vertices[v])
            self.adjList[sefl.vertices[v]].append(self.vertices[u])

def DirectedGraph(Graph):
    def __init__(self, edges):
        Graph.__init__(self,edges)
        self.__init_edges__()

    def __init_adjList__(self):
        for u,v in edges:
            self.adjList[self.vertices[u]].append(self.vertices[v])
        

class WeightedGraph(Graph):
    def __init__(self,edges,weights):
        Graph.__init__(self,edges)
        self.edges = {}
        self.__init_adjList__()
        for i in range(len(weights)):
            (u,v) = edges[i]
            self.edges[(self.vertices[u],self.vertices[v])]=weights[i]

    def __init_adjList__(self):
        for u,v in edges:
            self.edges[self.vertices[u]].append(self.vertices[v])
            self.edges[sefl.vertices[v]].append(self.vertices[u])

class DirectedWeightedGraph(Graph):
    def __init__(self,edges,weights):
        Graph.__init__(self,edges)
        self.edges = {}
        self.__init_adjList__()
        for i in range(len(weights)):
            (u,v) = edges[i]
            self.edges[(self.vertices[u],self.vertices[v])]=weights[i]

    def __init_adjList__(self):
        for u,v in edges:
            self.edges[self.vertices[u]].append(self.vertices[v])
            self.edges[sefl.vertices[v]].append(self.vertices[u])

    
        
        
    
